package com.halo.cloud.store.server.service.impl;


import com.halo.cloud.store.server.dao.BrandDao;
import com.halo.cloud.store.server.dao.CategoryDao;
import com.halo.cloud.store.server.dao.TypeDao;
import com.halo.cloud.store.server.service.CategoryService;
import com.halo.cloud.dto.CategoryDTO;
import com.halo.cloud.dto.KindDTO;
import com.halo.cloud.entity.store.Brand;
import com.halo.cloud.entity.store.Category;
import com.halo.cloud.entity.store.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/9
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private TypeDao typeDao;

    @Override
    public List<CategoryDTO> getCate() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<Category> categories = categoryDao.getCate();
        List<Brand> brands = brandDao.getBrand();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategories(categories);
        categoryDTO.setBrands(brands);
        categoryDTOS.add(categoryDTO);
        return categoryDTOS;
    }

    @Override
    public List<KindDTO> getCateByCateId(Integer cateId) {
        List<KindDTO> kindDTOs = new ArrayList<>();
        List<Type> types = typeDao.getTypeByCateId(cateId);
        List<Brand> brands = brandDao.getBrandByCateId(cateId);
        KindDTO kindDTO = new KindDTO();
        kindDTO.setTypes(types);
        kindDTO.setBrands(brands);
        kindDTOs.add(kindDTO);
        return kindDTOs;
    }


}
