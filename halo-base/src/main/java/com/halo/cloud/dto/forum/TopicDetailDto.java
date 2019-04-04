package com.halo.cloud.dto.forum;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/1 10:09
 * @Version 1.0
 */
public class TopicDetailDto implements Serializable {
    private Integer topicId;
    private Short typeId;
    private String typeName;
    private String title;
    private String content;
    private Integer userId;
    private String userName;
    private String avatar;
    private String updateTime;
    private Integer backNumber;
    private String lastTime;
    private List<BackDto> backList;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBackNumber() {
        return backNumber;
    }

    public void setBackNumber(Integer backNumber) {
        this.backNumber = backNumber;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public List<BackDto> getBackList() {
        return backList;
    }

    public void setBackList(List<BackDto> backList) {
        this.backList = backList;
    }

    @Override
    public String toString() {
        return "TopicDetailDto{" +
                "topicId=" + topicId +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", backNumber=" + backNumber +
                ", lastTime='" + lastTime + '\'' +
                ", backList=" + backList +
                '}';
    }
}
