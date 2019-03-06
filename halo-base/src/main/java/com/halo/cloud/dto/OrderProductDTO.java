package com.halo.cloud.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author MelloChan
 * @date 2018/6/10
 */
public class OrderProductDTO implements Serializable {

    private static final long serialVersionUID = 3304533797525751242L;
    @Min(1)
    private Integer proId;
    @NotBlank
    private String imgUrl;
    @NotBlank
    private String title;
    @Min(1)
    private Integer price;
    @Min(1)
    private Short number;
    @Min(1)
    private Integer total;

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

    public Short getNumber() {
        return number;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "OrderProductDTO{" +
                "proId=" + proId +
                ", imgUrl='" + imgUrl + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", total=" + total +
                '}';
    }
}
