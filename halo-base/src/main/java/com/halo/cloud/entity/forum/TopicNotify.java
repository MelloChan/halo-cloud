package com.halo.cloud.entity.forum;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/11 21:04
 * @Version 1.0
 */
public class TopicNotify implements Serializable {

    private Integer id;
    private Integer topicId;
    private Integer sender;
    private Integer receiver;
    private Short status;
    private Date gmtCreate;
    private Date gmtUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TopicNotify{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdated=" + gmtUpdated +
                '}';
    }
}
