package com.halo.cloud.store.server.dao;

import com.halo.cloud.entity.store.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Select("SELECT id,type_name " +
            "FROM hl_type " +
            "WHERE cate_id = #{cateId}")
    List<Type> getTypeByCateId(@Param("cateId") Integer cateId);
}
