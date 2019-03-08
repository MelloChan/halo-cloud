package com.halo.cloud.dto.store;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author MelloChan
 * @date 2018/6/10
 */
public class ReceiverInfoDTO implements Serializable {
    private static final long serialVersionUID = 153485277623949744L;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;

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
        return "ReceiverInfoDTO{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
