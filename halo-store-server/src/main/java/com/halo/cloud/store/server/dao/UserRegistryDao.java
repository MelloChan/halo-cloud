package com.halo.cloud.store.server.dao;

import com.halo.cloud.entity.store.UserRegistry;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/5/26
 */
@Mapper
public interface UserRegistryDao {
    /**
     * 通过手机号查找用户id
     *
     * @param phone 用户手机号
     * @return 用户id
     */
    @Select("SELECT id\n" +
            "        FROM hl_user_registry\n" +
            "        WHERE phone = #{phone}")
    Integer getIdByPhone(@Param("phone") String phone);

    /**
     * 通过手机号获取用户注册信息
     *
     * @param phone 用户手机号
     * @return 用户注册信息类
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            pwd,\n" +
            "            salt\n" +
            "        FROM hl_user_registry\n" +
            "        WHERE phone = #{phone}")
    UserRegistry getByPhone(@Param("phone") String phone);

    /**
     * 通过id获取用户注册信息
     *
     * @param userId 用户id
     * @return 用户盐与密码
     */
    @Select("SELECT\n" +
            "            pwd,\n" +
            "            salt\n" +
            "        FROM hl_user_registry\n" +
            "        WHERE id = #{userId}")
    UserRegistry getByUId(@Param("userId") Integer userId);

    /**
     * 插入用户注册信息
     *
     * @param userRegistry 用户注册信息类
     * @return 返回用户id
     */
    @Insert("INSERT INTO hl_user_registry (phone, pwd, salt)\n" +
            "        VALUES (#{phone}, #{pwd}, #{salt})")
    Integer insertUserRegistryInfo(UserRegistry userRegistry);

    /**
     * 更新密码
     *
     * @param salt   盐值
     * @param userId 用户id
     * @param newPwd 新密码
     * @return 影响条数
     */
    @Update("UPDATE hl_user_registry\n" +
            "        SET salt = #{salt}, pwd = #{newPwd}, gmt_updated = now()\n" +
            "        WHERE id = #{userId}")
    Integer updatePwdByUId(@Param("salt") String salt, @Param("newPwd") String newPwd, @Param("userId") Integer userId);

    /**
     * 更新手机号
     *
     * @param phone  用户手机号
     * @param userId 用户id
     * @return 影响条数
     */
    @Update("UPDATE hl_user_registry\n" +
            "        SET phone = #{phone}, gmt_updated = now()\n" +
            "        WHERE id = #{userId}")
    Integer updatePhoneByUId(@Param("phone") String phone, @Param("userId") Integer userId);

    /**
     * 通过用户手机号更新密码
     *
     * @param pwd   用户密码
     * @param phone 用户手机号
     * @return 影响条数
     */
    @Update("UPDATE hl_user_registry\n" +
            "        SET salt = #{salt}, pwd = #{pwd}, gmt_updated = now()\n" +
            "        WHERE phone = #{phone}")
    Integer updatePwdByPhone(@Param("pwd") String pwd, @Param("phone") String phone);

    /**
     * 通过用户id删除用户信息
     *
     * @param idList id列表
     */
    @Delete("<SCRIPT>" +
            "DELETE FROM hl_user_registry\n" +
            "        WHERE id IN\n" +
            "        <foreach collection=\"list\" item=\"idItem\" open=\"(\" separator=\",\" close=\")\">\n" +
            "            #{idItem}\n" +
            "        </foreach>" +
            "</SCRIPT>")
    void deleteUsersRegistry(@Param("list") List<Integer> idList);
}
