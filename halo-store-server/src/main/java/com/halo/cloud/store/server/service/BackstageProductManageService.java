package com.halo.cloud.store.server.service;


import com.halo.cloud.dto.ItemInfoDTO;

import java.util.List;

/**
 * @author SAIKAII
 * @date 2018/6/12
 */
public interface BackstageProductManageService {

    /**
     * 后台获取商品信息
     * @param pageIndex 商品数据下标
     * @param pageCount 一页显示的商品数量
     *
     */
    List<ItemInfoDTO> getItemsForBackstage(Integer pageIndex, Integer pageCount);

    /**
     * 后台删除指定商品所有相关信息
     * @param id 商品id
     */
    void deleteProduct(Integer id);

    /**
     * 后台删除指定的多个商品所有相关信息
     * @param idList 多个商品id
     */
    void deleteMultiProducts(List<Integer> idList);


    /**
     * 后台更改商品信息
     * @param pid 商品id
     * @param name 更改之后的商品名
     * @param num 增加/删减库存数
     * @param price 更改之后的商品价格
     */
    void updateProductInfoByPid(Integer pid, String name, Integer num, Integer price);

    /**
     * 后台通过商品类型和名字获取商品信息
     * @param type 类型
     * @param name 商品名
     * @param pageIndex 商品数据下标
     * @param pageCount 一页显示的数量
     */
    List<ItemInfoDTO> getItemsForBackstageByTypeAndName(String type, String name, Integer pageIndex, Integer pageCount);

    /**
     * 获取商品页数
     * @param pageCount 一页显示的商品数
     * @return 商品页数
     */
    Integer getNumOfPage(Integer pageCount);
}
