package com.halo.cloud.entity.forum;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/7 23:49
 * @Version 1.0
 */
public class Topic implements Serializable {
    private Integer id;
    private Integer userId;
    private Short typeId;
    private String title;
    private String content;
    private Short status;
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

    public Short getTypeId() {
        return typeId;
    }

    public void setTypeId(Short typeId) {
        this.typeId = typeId;
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


    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdated=" + gmtUpdated +
                '}';
    }
}
