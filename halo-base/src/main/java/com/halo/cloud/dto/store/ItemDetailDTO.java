package com.halo.cloud.dto.store;

import java.io.Serializable;

/**
 * @author MelloChan
 * @date 2018/5/22
 */
public class ItemDetailDTO implements Serializable {
    private static final long serialVersionUID = 5604644590202148848L;

    private String specificationJson;
    private String detailImg;
    public ItemDetailDTO(){}

    public ItemDetailDTO(String specificationJson,String detailImg) {
        this.specificationJson = specificationJson;
        this.detailImg = detailImg;
    }

    public String getSpecificationJson() {
        return specificationJson;
    }

    public void setSpecificationJson(String specificationJson) {
        this.specificationJson = specificationJson;
    }

    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    @Override
    public String toString() {
        return "ItemDetailDTO{" +
                "specificationJson='" + specificationJson + '\'' +
                ", detailImg='" + detailImg + '\'' +
                '}';
    }
}
