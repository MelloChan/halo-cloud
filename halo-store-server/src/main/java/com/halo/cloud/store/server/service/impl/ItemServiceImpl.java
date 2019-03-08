package com.halo.cloud.store.server.service.impl;

import com.halo.cloud.store.server.dao.ProductDao;
import com.halo.cloud.store.server.dao.ProductDetailDao;
import com.halo.cloud.store.server.dao.ProductSpecificationDao;
import com.halo.cloud.store.server.service.ItemService;


import com.halo.cloud.dto.store.ItemDTO;
import com.halo.cloud.dto.store.ItemDetailDTO;
import com.halo.cloud.entity.store.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/5/31
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductSpecificationDao productSpecificationDao;
    @Autowired
    private ProductDetailDao productDetailDao;

    @Override
    public List<ItemDTO> getItems(Integer pageIndex, Integer pageCount) {
        Integer index = (pageIndex - 1) * pageCount;
        List<Product> products = productDao.getItems(index, pageCount);
        return getItemList(products);
    }

    @Override
    public ItemDetailDTO getItemDetailByProId(Integer proId) {
        return new ItemDetailDTO(productSpecificationDao.getSpecificationByProId(proId), productDetailDao.getDescriptionByProId(proId));
    }

    @Override
    public List<ItemDTO> getItemsByCateId(Integer cateId) {
        List<Product> products = productDao.getItemsByCateId(cateId);
        return getItemList(products);
    }

    @Override
    public List<ItemDTO> getItemsByTypeId(Integer typeId) {
        List<Product> products = productDao.getItemsByTypeId(typeId);
        return getItemList(products);
    }

    @Override
    public List<ItemDTO> getItemsByBrandId(Integer brandId) {
        List<Product> products = productDao.getItemsByBrandId(brandId);
        return getItemList(products);
    }

    @Override
    public List<ItemDTO> getItemsByCateIdAndTypeId(Integer cateId, Integer typeId) {
        List<Product> products = productDao.getItemsByCateIdAndTypeId(cateId, typeId);
        return getItemList(products);
    }

    @Override
    public List<ItemDTO> getItemsByCateIdAndBrandId(Integer cateId, Integer brandId) {
        List<Product> products = productDao.getItemsByCateIdAndBrandId(cateId, brandId);
        return getItemList(products);
    }

    @Override
    public List<ItemDTO> searchItemByName(String name) {
        List<Product> products=productDao.searchItemByName(name);
        return getItemList(products);
    }

    @Override
    public Integer updateMinusStockByProId(Integer proId) {
        return productDao.updateMinusStockByProId(proId);
    }

    private List<ItemDTO> getItemList(List<Product> products) {
        List<ItemDTO> items = new ArrayList<>();
        ItemDTO item;
        for (Product product : products) {
            item = new ItemDTO(product.getId(), product.getImage(), product.getName(), product.getTitle(),
                    product.getPrice());
            items.add(item);
        }
        return items;
    }
}
