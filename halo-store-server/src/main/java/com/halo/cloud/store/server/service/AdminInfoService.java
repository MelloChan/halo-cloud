package com.halo.cloud.store.server.service;


import com.halo.cloud.entity.Admin;

/**
 * @author SAIKAII
 * @date 2018/6/6
 */
public interface AdminInfoService {

    /**
     * 验证是否有该账号存在
     *
     * @param username 管理员账号
     *
     */
    boolean verityByUsername(String username);

    /**
     * 验证管理员密码
     *
     * @param username 管理员账号
     * @param pwd 密码
     *
     */
    boolean verify(String username, String pwd);

    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     */
    void insertAdmin(Admin admin);
}
