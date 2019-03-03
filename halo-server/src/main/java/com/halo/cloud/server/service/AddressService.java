package com.halo.cloud.server.service;


import dto.AddressDTO;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/10
 */
public interface AddressService {
    /**
     * 获取用户地址列表
     */
    List<AddressDTO> getByUId(Integer userId);

    /**
     * 插入地址信息
     */
    Integer insertAddressInfo(Integer userId, AddressDTO addressDTO);

    /**
     * 更新用户地址
     */
    void updateAddressInfoById(Integer userId, AddressDTO addressDTO);

    /**
     * 删除用户地址
     */
    void deleteAddressInfoById(Integer userId, Integer id);
}
