package com.halo.cloud.store.server.service;



import com.halo.cloud.dto.CategoryDTO;
import com.halo.cloud.dto.KindDTO;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/9
 */
public interface CategoryService {
    /**
     * 获取分类属性
     */
    List<CategoryDTO> getCate();

    /**
     * 根据分类id获取具体类型与品牌
     */
    List<KindDTO> getCateByCateId(Integer cateId);
}
