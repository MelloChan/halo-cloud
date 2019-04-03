package com.halo.cloud.dto.forum;

import java.io.Serializable;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/1 10:03
 * @Version 1.0
 */
public class TopicDto implements Serializable {
    private Integer topicId;
    private String title;
    private Integer userId;
    private String userName;
    private String avatar;
    private Short typeId;
    private String typeName;
    private String lastTime;
    private String lastBack;
    private Integer backNumber;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Short getTypeId() {
        return typeId;
    }

    public void setTypeId(Short typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastBack() {
        return lastBack;
    }

    public void setLastBack(String lastBack) {
        this.lastBack = lastBack;
    }

    public Integer getBackNumber() {
        return backNumber;
    }

    public void setBackNumber(Integer backNumber) {
        this.backNumber = backNumber;
    }

    @Override
    public String toString() {
        return "TopicDto{" +
                "topicId=" + topicId +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", lastBack='" + lastBack + '\'' +
                ", backNumber=" + backNumber +
                '}';
    }
}
