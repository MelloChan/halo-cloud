package com.halo.cloud.dto.store;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author SAIKAII
 * @date 2018/6/17
 */
public class OrderListDTO implements Serializable {
    private static final long serialVersionUID = -2178932727250096500L;
    private String id;
    private String uid;
    private Date gmtUpdated;
    private List<OrderProductDTO> products;
    private Integer price;
    private Short status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    public List<OrderProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProductDTO> products) {
        this.products = products;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderListDTO{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", gmtUpdated=" + gmtUpdated +
                ", products=" + products +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
