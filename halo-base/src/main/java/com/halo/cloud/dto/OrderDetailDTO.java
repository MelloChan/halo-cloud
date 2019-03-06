package com.halo.cloud.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/10
 */
public class OrderDetailDTO implements Serializable{
    private static final long serialVersionUID = 673372102167297677L;

    @NotBlank
    private String id;
    private ReceiverInfoDTO receiver;
    private List<OrderProductDTO>products;
    @Min(1)
    @Max(3)
    private Short payType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ReceiverInfoDTO getReceiver() {
        return receiver;
    }

    public void setReceiver(ReceiverInfoDTO receiver) {
        this.receiver = receiver;
    }

    public List<OrderProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProductDTO> products) {
        this.products = products;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "id=" + id +
                ", receiver=" + receiver +
                ", products=" + products +
                ", payType=" + payType +
                '}';
    }
}
