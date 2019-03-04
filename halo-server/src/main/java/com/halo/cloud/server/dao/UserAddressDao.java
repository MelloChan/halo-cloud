package com.halo.cloud.server.dao;

import entity.UserAddress;
import org.apache.ibatis.annotations.*;

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
    @Select("SELECT\n" +
            "            id,\n" +
            "            user_name,\n" +
            "            user_phone,\n" +
            "            user_address\n" +
            "        FROM hl_user_address\n" +
            "        WHERE user_id = #{userId}")
    List<UserAddress> getByUId(@Param("userId") Integer userId);

    /**
     * 插入用户地址信息
     */
    @Insert("INSERT INTO hl_user_address (user_id, user_name, user_phone, user_address, gmt_create, gmt_updated)\n" +
            "VALUES (#{userId}, #{userName}, #{userPhone}, #{userAddress}, now(), now())")
    Integer insertAddressInfo(UserAddress userAddress);

    /**
     * 通过地址id与用户id更新地址信息
     */
    @Update("UPDATE hl_user_address\n" +
            "SET user_name = #{userName}, user_phone = #{userPhone}, user_address = #{userAddress}, gmt_updated = now()\n" +
            "WHERE user_id = #{userId} AND id = #{id}")
    void updateAddressInfoByUIdAndId(UserAddress userAddress);

    /**
     * 通过地址id与用户id删除地址信息
     */
    @Delete("DELETE FROM hl_user_address\n" +
            "WHERE user_id = #{userId} AND id = #{id}")
    void deleteAddressInfoByUIdAndId(@Param("userId") Integer userId, @Param("id") Integer id);

    /**
     * 通过用户id删除地址
     *
     * @param idList id列表
     */
    @Delete("<SCRIPT>" +
            "DELETE FROM hl_user_address\n" +
            "        WHERE user_id IN\n" +
            "        <foreach collection=\"list\" item=\"idItem\" open=\"(\" separator=\",\" close=\")\">\n" +
            "            #{idItem}\n" +
            "        </foreach>" +
            "</SCRIPT>")
    void deleteUsersAddress(@Param("list") List<Integer> idList);
}
