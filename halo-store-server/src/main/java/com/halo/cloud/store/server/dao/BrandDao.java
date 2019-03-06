package com.halo.cloud.store.server.dao;

import com.halo.cloud.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/1
 */
@Mapper
public interface BrandDao {
    /**
     * 获取品牌
     */
    @Select(" SELECT id,brand_name FROM hl_brand LIMIT 0,7")
    List<Brand> getBrand();

    /**
     * 根据分类id获取品牌
     */
    @Select(" SELECT id,brand_name FROM hl_brand WHERE cate_id = #{cateId}")
    List<Brand> getBrandByCateId(@Param("cateId") Integer cateId);
}
