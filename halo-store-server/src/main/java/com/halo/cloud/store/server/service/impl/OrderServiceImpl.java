package com.halo.cloud.store.server.service.impl;

import com.halo.cloud.dto.store.*;
import com.halo.cloud.entity.store.Order;
import com.halo.cloud.entity.store.OrderProduct;
import com.halo.cloud.entity.store.OrderShipment;
import com.halo.cloud.store.server.dao.OrderDao;
import com.halo.cloud.store.server.dao.OrderProductDao;
import com.halo.cloud.store.server.dao.OrderShipmentDao;
import com.halo.cloud.store.server.service.CartService;
import com.halo.cloud.store.server.service.ItemService;
import com.halo.cloud.store.server.service.OrderService;
import com.halo.cloud.util.RedisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.halo.cloud.util.DigestUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/10
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderShipmentDao orderShipmentDao;
    @Autowired
    private OrderProductDao orderProductDao;

    @Override
    public String generateOrderId(Integer userId) {
        String orderId = DigestUtil.generateSalt();
        redisUtil.add(orderId, 60 * 30L, String.valueOf(userId));
        return orderId;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String insertOrderInfo(Integer userId, OrderDetailDTO orderDetailDTO, HttpServletRequest request) throws UnsupportedEncodingException {
        List<OrderProductDTO> products = orderDetailDTO.getProducts();
        String orderId = orderDetailDTO.getId();
        int total = 0;

        // 保存订单商品信息
        OrderProduct orderProduct;
        for (OrderProductDTO product : products) {
            int proId = product.getProId();
            if (checkStock(proId)) {
                orderProduct = new OrderProduct(proId, orderId, product.getImgUrl(), product.getTitle(),
                        product.getPrice(), product.getTotal(), product.getNumber());
                orderProductDao.insertOrderProductInfo(orderProduct);
                cartService.deleteCart(proId, request);
            } else {
                return product.getTitle();
            }
            total += product.getTotal();
        }

        // 保存配送信息
        ReceiverInfoDTO receiverInfoDTO = orderDetailDTO.getReceiver();
        OrderShipment orderShipment = new OrderShipment(orderId, receiverInfoDTO.getName(), receiverInfoDTO.getPhone(), receiverInfoDTO.getAddress());
        orderShipmentDao.insertOrderShipmentInfo(orderShipment);

        // 保存订单信息
        short payType = orderDetailDTO.getPayType();
        Order order = new Order(orderId, userId, payType, (short) 1, total, total);
        orderDao.insertOrderInfo(order);
        return orderId;
    }

    @Override
    public List<OrderProductListDTO> getOrderProductListByUserId(Integer userId) {
        List<OrderProductListDTO> orderProductListDTOS = new ArrayList<>();
        OrderProductListDTO orderProductListDTO;
        OrderProductDTO orderProductDTO;
        List<Order> orders = orderDao.getByUId(userId);
        List<String> ids = new ArrayList<>();
        for (Order order : orders) {
            ids.add(order.getId());
        }
        if (ids.size() <= 0) {
            return orderProductListDTOS;
        }
        List<OrderProduct> orderProducts = orderProductDao.getOrderProductByOrderIds(ids);
        List<OrderProductDTO> orderProductDTOS = new ArrayList<>();
        for (Order order : orders) {
            orderProductListDTO = new OrderProductListDTO();
            orderProductListDTO.setId(order.getId());
            orderProductListDTO.setGmtUpdated(order.getGmtUpdated());
            orderProductListDTO.setPrice(order.getPayAmount());
            orderProductListDTO.setStatus(order.getOrderStatus());
            for (OrderProduct orderProduct : orderProducts) {
                orderProductDTO = new OrderProductDTO();
                orderProductDTO.setTitle(orderProduct.getTitle());
                orderProductDTO.setProId(orderProduct.getProId());
                orderProductDTO.setPrice(orderProduct.getPrice());
                orderProductDTO.setNumber(orderProduct.getNumber());
                orderProductDTO.setTotal(orderProduct.getTotalFee());
                orderProductDTO.setImgUrl(orderProduct.getImage());
                orderProductDTOS.add(orderProductDTO);
            }
            orderProductListDTO.setProducts(orderProductDTOS);
            orderProductListDTOS.add(orderProductListDTO);
        }
        return orderProductListDTOS;
    }

    @Override
    public OrderDetailDTO getOrderByOrderId(String orderId) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setId(orderId);

        // 设置配送地址
        OrderShipment orderShipment = orderShipmentDao.getOrderShipmentByOrderId(orderId);
        ReceiverInfoDTO receiverInfoDTO = new ReceiverInfoDTO();
        receiverInfoDTO.setName(orderShipment.getReceiverName());
        receiverInfoDTO.setPhone(orderShipment.getReceiverPhone());
        receiverInfoDTO.setAddress(orderShipment.getReceiverAddress());
        orderDetailDTO.setReceiver(receiverInfoDTO);

        // 配置订单商品信息
        List<OrderProduct> orderProducts = orderProductDao.getOrderProductByOrderId(orderId);
        List<OrderProductDTO> orderProductDTOS = new ArrayList<>();
        OrderProductDTO orderProductDTO;
        for (OrderProduct product : orderProducts) {
            orderProductDTO = new OrderProductDTO();
            orderProductDTO.setImgUrl(product.getImage());
            orderProductDTO.setNumber(product.getNumber());
            orderProductDTO.setPrice(product.getPrice());
            orderProductDTO.setProId(product.getProId());
            orderProductDTO.setTitle(product.getTitle());
            orderProductDTO.setTotal(product.getTotalFee());
            orderProductDTOS.add(orderProductDTO);
        }
        orderDetailDTO.setProducts(orderProductDTOS);
        orderDetailDTO.setPayType(orderDao.getPayTypeByOrderId(orderId));
        return orderDetailDTO;
    }

    @Override
    public Short getStatusByOrderId(String orderId) {
        return orderDao.getStatusByOrderId(orderId);
    }

    @Override
    public List<OrderListDTO> getOrders(Integer pageIndex, Integer pageCount) {
        pageIndex = (pageIndex - 1) * pageCount;
        return orderDao.getOrders(pageIndex, pageCount);
    }

    @Override
    public List<OrderListDTO> getOrdersByStatus(Short status, Integer pageIndex, Integer pageCount) {
        pageIndex = (pageIndex - 1) * pageCount;
        return orderDao.getOrdersByStatus(status, pageIndex, pageCount);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrderStatusById(String id, Short status) {
        orderDao.updateOrderStatusById(id, status);
    }

    @Override
    public Integer getNumOfPages(Integer pageCount) {
        return (orderDao.getNumOfOrder() + pageCount - 1) / pageCount;
    }

    private boolean checkStock(int proId) {
        return itemService.updateMinusStockByProId(proId) > 0;
    }

}
