package com.halo.cloud.dto.forum;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/3 20:39
 * @Version 1.0
 */
public class BackMsgDto {
    private Integer topicId;
    private Integer senderId;
    private String senderName;
    private Integer backId;
    private String title;
    private String content;
    private String createTime;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getBackId() {
        return backId;
    }

    public void setBackId(Integer backId) {
        this.backId = backId;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BackMsgDto{" +
                "topicId=" + topicId +
                ", senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", backId=" + backId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
