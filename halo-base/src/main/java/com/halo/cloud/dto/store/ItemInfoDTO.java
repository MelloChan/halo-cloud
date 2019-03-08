package com.halo.cloud.dto.store;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台展示商品信息
 *
 * @author SAIKAII
 * @date 2018/6/12
 */
public class ItemInfoDTO implements Serializable{

    private static final long serialVersionUID = -203380720987915929L;
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer stock;
    private String typeName;
    private Date gmtCreate;
    private Date gmtUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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
        return "ItemInfoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", typeName='" + typeName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdated=" + gmtUpdated +
                '}';
    }
}
