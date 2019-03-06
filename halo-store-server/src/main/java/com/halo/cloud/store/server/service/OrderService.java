package com.halo.cloud.store.server.service;



import com.halo.cloud.dto.OrderDetailDTO;
import com.halo.cloud.dto.OrderListDTO;
import com.halo.cloud.dto.OrderProductListDTO;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/6
 */
public interface OrderService {
    /**
     * 生成订单号
     */
    String generateOrderId(Integer userId);

    /**
     * 插入订单信息
     */
    String insertOrderInfo(Integer userId, OrderDetailDTO orderDetailDTO, HttpServletRequest request) throws UnsupportedEncodingException;

    /**
     * 获取用户订单商品列表
     */
    List<OrderProductListDTO> getOrderProductListByUserId(Integer userId);

    /**
     * 通过订单id获取订单详情
     */
    OrderDetailDTO getOrderByOrderId(String orderId);

    /**
     * 根据订单id获取支付状态
     */
    Short getStatusByOrderId(String orderId);

    /**
     * 获取所有订单详情
     */
    List<OrderListDTO> getOrders(Integer pageIndex, Integer pageCount);

    /**
     * 通过状态筛选订单
     */
    List<OrderListDTO> getOrdersByStatus(Short status, Integer pageIndex, Integer pageCount);

    /**
     * 通过订单id更改订单状态
     */
    void updateOrderStatusById(String id, Short status);

    /**
     * 获取订单页数
     * @param pageCount 一页显示的订单数
     * @return 订单页数
     */
    Integer getNumOfPages(Integer pageCount);
}
