package com.halo.cloud.server.dao;

import entity.UserProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/5/27
 */
@Mapper
public interface UserProfileDao {
    /**
     * 插入用户个人信息
     *
     * @param userProfile 用户个人信息类
     */
    void insertUserProfileInfo(UserProfile userProfile);

    /**
     * 通过用户Id获取用户信息
     *
     * @param userId 用户注册时赋值的唯一id
     * @return 用户个人信息
     */
    UserProfile getUserProfileInfoByUId(@Param("userId") Integer userId);

    /**
     * 通过用户id获取用户哈币数值
     *
     * @param userId 用户id
     * @return 哈币
     */
    Integer getHaloCoinByUId(@Param("userId") Integer userId);

    /**
     * 通过用户名查询用户id
     *
     * @param username 用户名
     * @return 用户个人信息id
     */
    Integer getIdByUsername(@Param("username") String username);

    /**
     * 通过邮箱查询用户id
     *
     * @param email 用户邮箱
     * @return 用户个人信息id
     */
    Integer getIdByEmail(@Param("email") String email);

    /**
     * 更新哈币
     *
     * @param number 更新的数值
     * @param userId 用户ID
     * @return 返回影响条数
     */
    Integer updateCoinByUId(@Param("number") Integer number, @Param("userId") Integer userId);

    /**
     * 更新头像
     *
     * @param imgUrl 七牛云外链地址
     * @param userId 用户id
     */
    void updateAvatarById(@Param("imgUrl") String imgUrl, @Param("userId") Integer userId);

    /**
     * 更新邮箱
     *
     * @param email  用户邮箱
     * @param userId 用户id
     */
    Integer updateEmailById(@Param("email") String email, @Param("userId") Integer userId);

    /**
     * 更新手机号
     *
     * @param phone  用户手机号
     * @param userId 用户id
     * @return 影响条数
     */
    Integer updatePhoneByUId(@Param("phone") String phone, @Param("userId") Integer userId);


    /**
     * * 获取所有用户的个人信息
     *
     * @param pageIndex 第几页
     * @param pageCount 一页显示的数据量
     * @return 所有用户的个人信息
     */
    List<UserProfile> getUsersProfile(@Param("pageIndex") Integer pageIndex, @Param("pageCount") Integer pageCount);

    /**
     * 删除指定用户
     *
     * @param idList 用户id列表
     */
    void deleteUsersProfile(List<Integer> idList);

    /**
     * 获取指定用户的个人信息
     *
     * @param uid 用户id
     * @return 返回指定用户的个人信息
     */
    UserProfile getUserProfileByUId(@Param("uid") Integer uid);

    /**
     * 获取数据库中用户数量
     *
     * @return 返回用户数
     */
    Integer getNumOfUsers();
}
