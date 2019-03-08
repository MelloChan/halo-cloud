package com.halo.cloud.dto.store;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SAIKAII
 * @date 2018/6/14
 */
public class BackstageUserProfileDTO implements Serializable {
    private static final long serialVersionUID = 8467902412022535299L;
    private Integer userId;
    private String username;
    private Short securityLevel;
    private String email;
    private String phone;
    private Date gmtCreate;
    private Date gmtUpdate;

    public BackstageUserProfileDTO(Integer userId, String username, Short securityLevel, String email, String phone, Date gmtCreate, Date gmtUpdate) {
        this.userId = userId;
        this.username = username;
        this.securityLevel = securityLevel;
        this.email = email;
        this.phone = phone;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Override
    public String toString() {
        return "BackstageUserProfileDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", securityLevel=" + securityLevel +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }
}
