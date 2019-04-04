package com.halo.cloud.dto.forum;

import java.io.Serializable;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/1 10:12
 * @Version 1.0
 */
public class BackDto implements Serializable {
    private Integer backId;
    private Integer userId;
    private String userName;
    private String avatar;
    private String backTime;
    private String content;

    public Integer getBackId() {
        return backId;
    }

    public void setBackId(Integer backId) {
        this.backId = backId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "BackDto{" +
                "backId=" + backId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", backTime='" + backTime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
