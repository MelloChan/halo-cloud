package com.halo.cloud.server.dao;


import dto.OrderListDTO;
import entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/6
 */
@Mapper
public interface OrderDao {
    /**
     * 插入订单信息
     */
    @Insert("INSERT INTO hl_order (id, user_id, pay_type, order_status, order_amount, pay_amount, gmt_create, gmt_updated)" +
            "VALUES (#{id}, #{userId}, #{payType}, #{orderStatus}, #{orderAmount}, #{payAmount}, now(), now())")
    boolean insertOrderInfo(Order order);

    /**
     * 根据用户id获取用户的所有订单部分信息
     */
    @Select("SELECT id,order_status,pay_amount,gmt_updated FROM hl_order WHERE user_id = #{userId}")
    List<Order> getByUId(@Param("userId") Integer userId);

    /**
     * 根据订单id获取订单状态
     */
    @Select("SELECT order_status FROM hl_order WHERE id = #{orderId}")
    Short getStatusByOrderId(@Param("orderId") String orderId);

    /**
     * 根据订单id获取订单支付类型
     */
    @Select("SELECT pay_type FROM hl_order WHERE id = #{orderId}")
    Short getPayTypeByOrderId(@Param("orderId") String orderId);

    /**
     * 返回所有订单详情
     */
    @Select("SELECT hl_order.id,user_id,hl_order.gmt_updated,pay_amount,order_status,pro_id,image,title,price,number,total_fee " +
            "FROM hl_order, hl_order_product WHERE hl_order.id = order_id LIMIT #{pageIndex}, #{pageCount}")
    List<OrderListDTO> getOrders(@Param("pageIndex") Integer pageIndex,
                                 @Param("pageCount") Integer pageCount);

    /**
     * 通过状态筛选订单
     */
    @Select("SELECT hl_order.id,user_id,hl_order.gmt_updated,pay_amount,order_status,pro_id,image,title,price,number,total_fee " +
            "FROM hl_order, hl_order_product " +
            "WHERE hl_order.id = order_id AND order_status = #{status} LIMIT #{pageIndex}, #{pageCount}")
    List<OrderListDTO> getOrdersByStatus(@Param("status") Short status,
                                         @Param("pageIndex") Integer pageIndex,
                                         @Param("pageCount") Integer pageCount);

    /**
     * 通过订单id更改订单状态
     */
    @Update("UPDATE hl_order SET order_status = #{status} " +
            "WHERE id = #{id}")
    void updateOrderStatusById(@Param("id") String id, @Param("status") Short status);

    /**
     * 获得所有订单数
     */
    @Select("SELECT count(id) AS totalOrder FROM hl_order")
    Integer getNumOfOrder();

    /**
     * 获得未发货订单数
     */
    @Select("SELECT count(id) AS totalOrder FROM hl_order WHERE order_status = 2")
    Integer getNumOfNoHandledOrder();

    /**
     * 获得成交总额
     */
    @Select("SELECT sum(order_amount) FROM hl_order WHERE order_status = 4")
    Integer getTotalTurnOver();

    /**
     * 获取一个月内魅族销售量
     */
    @Select("SELECT count(hl_order_product.id) FROM hl_order_product, hl_order WHERE hl_order.id = order_id AND title LIKE '%魅族%' AND 1 > TIMESTAMPDIFF(MONTH, hl_order_product.gmt_updated, now()) AND order_status = 4")
    Integer getMeiZuSales();

    /**
     * 获取一个月内魅蓝销售量
     */
    @Select("SELECT count(hl_order_product.id) FROM hl_order_product, hl_order WHERE hl_order.id = order_id AND title LIKE '%魅蓝%' AND 1 > TIMESTAMPDIFF(MONTH, hl_order_product.gmt_updated, now()) AND order_id = 4")
    Integer getMeiLanSales();

}
