package com.halo.cloud.server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author MelloChan
 * @date 2018/5/31
 */
@Mapper
public interface ProductDetailDao {

    @Select("SELECT description " +
            "FROM hl_product_detail WHERE pro_id=#{proId}")
    String getDescriptionByProId(@Param("proId") Integer proId);
}
