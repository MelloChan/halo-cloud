package com.halo.cloud.server.dao;

import entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/1
 */
@Mapper
public interface TypeDao {
    /**
     * 根据分类id查找
     */
    List<Type>getTypeByCateId(@Param("cateId") Integer cateId);
}
