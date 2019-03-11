package com.halo.cloud.entity.forum;

import java.io.Serializable;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/11 21:04
 * @Version 1.0
 */
public class Notify implements Serializable {

    private Integer topicId;
    private Integer sender;
    private Integer receiver;
    private Short status;

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
        return "Notify{" +
                "topicId=" + topicId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", status=" + status +
                '}';
    }
}
