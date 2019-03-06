package com.halo.cloud.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MelloChan
 */
public class ProductImage implements Serializable {
    private static final long serialVersionUID = -6192233338153999299L;
    private Integer id;
    private String imgUrl;
    private Integer proId;
    private Date gmtCreate;
    private Date gmtUpdated;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
}
