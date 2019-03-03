package com.halo.cloud.server.dao;

import entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/5/31
 */
@Mapper
public interface CategoryDao {
    /**
     * 获取分类属性
     */
    @Select("  SELECT id,cate_name FROM hl_category")
    List<Category> getCate();
}
