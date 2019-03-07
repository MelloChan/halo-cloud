package com.halo.cloud.entity.store;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MelloChan
 */
public class UserProfile implements Serializable {
    private static final long serialVersionUID = -3530204100472162294L;
    private Integer id;
    private Integer userId;
    private String username;
    private String avatar;
    private Short securityLevel;
    private String email;
    private String phone;
    private String pwdProtection;
    private Integer hlCoin;
    private Date gmtCreate;
    private Date gmtUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Short getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Short securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwdProtection() {
        return pwdProtection;
    }

    public void setPwdProtection(String pwdProtection) {
        this.pwdProtection = pwdProtection;
    }

    public Integer getHlCoin() {
        return hlCoin;
    }

    public void setHlCoin(Integer hlCoin) {
        this.hlCoin = hlCoin;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }
}
