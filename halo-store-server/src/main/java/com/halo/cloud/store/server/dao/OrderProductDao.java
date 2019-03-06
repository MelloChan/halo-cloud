package com.halo.cloud.store.server.dao;

import com.halo.cloud.entity.OrderProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/6
 */
@Mapper
public interface OrderProductDao {
    /**
     * 插入订单商品信息
     */
    @Insert("INSERT INTO hl_order_product (pro_id, order_id, image, title, price, total_fee, number, gmt_create, gmt_updated)" +
            "VALUES (#{proId}, #{orderId}, #{image}, #{title}, #{price}, #{totalFee}, #{number}, now(), now())")
    void insertOrderProductInfo(OrderProduct orderProduct);

    /**
     * 通过订单id列表获取订单商品
     */
    @Select("<SCRIPT>" +
            "SELECT pro_id,image,title,price,total_fee,number,gmt_updated FROM hl_order_product WHERE order_id IN" +
            "        <foreach item=\"orderId\" index=\"index\" collection=\"ids\"\n" +
            "                 open=\"(\" separator=\",\" close=\")\">\n" +
            "            #{orderId}\n" +
            "        </foreach>" +
            "</SCRIPT>")
    List<OrderProduct> getOrderProductByOrderIds(@Param("ids") List<String> ids);

    /**
     * 根据订单id获取订单商品
     */
    @Select("SELECT pro_id,image,title,price,total_fee,number,gmt_updated FROM hl_order_product" +
            "WHERE order_id = #{orderId}")
    List<OrderProduct> getOrderProductByOrderId(@Param("orderId") String orderId);
}
