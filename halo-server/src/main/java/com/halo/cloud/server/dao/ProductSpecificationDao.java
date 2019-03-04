package com.halo.cloud.server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author MelloChan
 * @date 2018/5/31
 */
@Mapper
public interface ProductSpecificationDao {

    @Select("SELECT specification " +
            "FROM hl_product_specification " +
            "WHERE pro_id=#{proId}")
    String getSpecificationByProId(@Param("proId") Integer proId);
}
