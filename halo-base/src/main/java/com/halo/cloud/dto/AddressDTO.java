package com.halo.cloud.dto;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author MelloChan
 * @date 2018/6/10
 */
public class AddressDTO implements Serializable {
    private static final long serialVersionUID = -6933186620119081688L;
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
