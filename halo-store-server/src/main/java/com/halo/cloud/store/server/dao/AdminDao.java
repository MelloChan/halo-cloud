package com.halo.cloud.store.server.dao;


import com.halo.cloud.entity.store.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author SAIKAII
 * @date 2018/6/6
 */

@Mapper
public interface AdminDao {

    /**
     * 获取指定管理员信息
     *
     * @param username 管理员用户名
     * @return 管理员的信息
     */
    @Select("SELECT id, pwd, salt, email FROM hl_admin WHERE username = #{username}")
    Admin getAdminInfoByUsername(@Param("username") String username);


    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     */
    @Insert("INSERT INTO hl_admin(username, pwd, salt, email, gmt_create, gmt_updated) " +
            "VALUE(#{username}, #{pwd}, #{salt}, #{email}, now(), now())")
    boolean insertAdminInfo(Admin admin);

}
