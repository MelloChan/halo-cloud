package com.halo.cloud.dto.store;

import java.io.Serializable;

/**
 * 用户个人中心信息传输对象
 *
 * @author MelloChan
 * @date 2018/5/17
 */
public class UserProfileInfoDTO implements Serializable {
    private static final long serialVersionUID = -3679318423202185947L;

    private String username;
    private String avatar;
    private Short securityLevel;
    private String email;
    private String phone;
    private String pwdProtection;
    public UserProfileInfoDTO(){}

    public UserProfileInfoDTO(String username, String avatar, Short securityLevel, String email, String phone, String pwdProtection) {
        this.username = username;
        this.avatar = avatar;
        this.securityLevel = securityLevel;
        this.email = email;
        this.phone = phone;
        this.pwdProtection = pwdProtection;
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

    @Override
    public String toString() {
        return "UserProfileInfoDTO{" +
                "username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", securityLevel=" + securityLevel +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", pwdProtection='" + pwdProtection + '\'' +
                '}';
    }
}
