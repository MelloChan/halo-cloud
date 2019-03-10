package com.halo.cloud.forum.server.dao;

import com.halo.cloud.entity.forum.Type;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/10 22:58
 * @Version 1.0
 */
@Repository
public interface TypeDao {

    @Select("SELECT id,type_name FROM hl_type")
    List<Type> listAll();

    @Select("SELECT id,type_name FROM hl_type WHERE id = #{id}")
    Type getTypeById(@Param("id") Integer id);

}
