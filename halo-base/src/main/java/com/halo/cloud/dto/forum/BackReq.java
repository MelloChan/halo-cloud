package com.halo.cloud.dto.forum;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/3 20:33
 * @Version 1.0
 */
public class BackReq {
    private Integer topicId;
    private Integer sender;
    private String content;
    private List<Integer> receivers;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Integer> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Integer> receivers) {
        this.receivers = receivers;
    }

    @Override
    public String toString() {
        return "BackReq{" +
                "topicId=" + topicId +
                ", sender=" + sender +
                ", content='" + content + '\'' +
                ", receivers=" + receivers +
                '}';
    }
}
