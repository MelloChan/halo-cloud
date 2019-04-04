package com.halo.cloud.entity.forum;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/7 23:53
 * @Version 1.0
 */
public class TopicType implements Serializable {
    private Integer id;
    private String typeName;
    private Date gmtCreate;
    private Date gmtUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        return "TopicType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdated=" + gmtUpdated +
                '}';
    }
}
