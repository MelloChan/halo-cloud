package com.halo.cloud.entity.forum;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/7 23:54
 * @Version 1.0
 */
public class Msg implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer friendId;
    private Integer sender;
    private Integer receiver;
    private String typeName;
    private Short status;
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

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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
        return "Msg{" +
                "id=" + id +
                ", userId=" + userId +
                ", friendId=" + friendId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", typeName='" + typeName + '\'' +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdated=" + gmtUpdated +
                '}';
    }
}
