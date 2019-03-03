package com.halo.cloud.server.dao;

import entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/10
 */
@Mapper
public interface UserAddressDao {
    /**
     * 根据用户id查找用户地址信息列表
     */
    List<UserAddress> getByUId(@Param("userId") Integer userId);

    /**
     * 插入用户地址信息
     */
    Integer insertAddressInfo(UserAddress userAddress);

    /**
     * 通过地址id与用户id更新地址信息
     */
    void updateAddressInfoByUIdAndId(UserAddress userAddress);

    /**
     * 通过地址id与用户id删除地址信息
     */
    void deleteAddressInfoByUIdAndId(@Param("userId") Integer userId, @Param("id") Integer id);

    /**
     * 通过用户id删除地址
     * @param idList id列表
     */
    void deleteUsersAddress(List<Integer> idList);
}
