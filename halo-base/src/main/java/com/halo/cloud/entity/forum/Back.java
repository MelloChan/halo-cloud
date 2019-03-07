package com.halo.cloud.entity.forum;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/7 23:52
 * @Version 1.0
 */
public class Back implements Serializable {
    private Integer id;
    private Integer userId;
    private Short topicId;
    private String content;
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

    public Short getTopicId() {
        return topicId;
    }

    public void setTopicId(Short topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "Back{" +
                "id=" + id +
                ", userId=" + userId +
                ", topicId=" + topicId +
                ", content='" + content + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdated=" + gmtUpdated +
                '}';
    }
}
