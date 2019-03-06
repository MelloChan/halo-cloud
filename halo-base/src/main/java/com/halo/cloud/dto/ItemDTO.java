package com.halo.cloud.dto;

import java.io.Serializable;

/**
 * 展示页面商品信息
 *
 * @author MelloChan
 * @date 2018/5/16
 */
public class ItemDTO implements Serializable {

    private static final long serialVersionUID = -3486758677948381701L;
    private Integer proId;
    private String imgUrl;
    private String name;
    private String title;
    private Integer price;

    public ItemDTO() {
    }

    public ItemDTO(Integer proId, String imgUrl, String name, String title, Integer price) {
        this.proId = proId;
        this.imgUrl = imgUrl;
        this.name = name;
        this.title = title;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "proId=" + proId +
                ", imgUrl='" + imgUrl + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
