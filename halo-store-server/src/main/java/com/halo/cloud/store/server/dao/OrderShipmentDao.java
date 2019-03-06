package com.halo.cloud.store.server.dao;

import com.halo.cloud.entity.OrderShipment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author MelloChan
 * @date 2018/6/6
 */
@Mapper
public interface OrderShipmentDao {
    /**
     * 保存配送信息
     */
    @Insert("INSERT INTO hl_order_shipment (order_id, receiver_name, receiver_phone, receiver_address, gmt_create, gmt_updated) " +
            "VALUES (#{orderId}, #{receiverName}, #{receiverPhone}, #{receiverAddress}, now(), now())")
    void insertOrderShipmentInfo(OrderShipment orderShipment);

    /**
     * 通过订单id获取配送信息
     */
    @Select("SELECT receiver_name,receiver_phone,receiver_address " +
            "FROM hl_order_shipment " +
            "WHERE order_id = #{orderId}")
    OrderShipment getOrderShipmentByOrderId(@Param("orderId") String orderId);
}
