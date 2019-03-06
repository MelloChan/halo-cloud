package com.halo.cloud.dto;


import com.halo.cloud.entity.Brand;
import com.halo.cloud.entity.Category;

import java.io.Serializable;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/5/17
 */
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 6032728683904816818L;

    private List<Category> categories;
    private List<Brand> brands;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categories=" + categories +
                ", brands=" + brands +
                '}';
    }
}
