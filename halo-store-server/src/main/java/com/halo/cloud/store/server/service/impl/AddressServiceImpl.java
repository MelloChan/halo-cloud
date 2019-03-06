package com.halo.cloud.store.server.service.impl;


import com.halo.cloud.dto.AddressDTO;
import com.halo.cloud.entity.UserAddress;
import com.halo.cloud.store.server.dao.UserAddressDao;
import com.halo.cloud.store.server.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/10
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public List<AddressDTO> getByUId(Integer userId) {
        List<UserAddress> userAddresses = userAddressDao.getByUId(userId);
        List<AddressDTO> addressDTOS = new ArrayList<>();
        AddressDTO addressDTO;
        for (UserAddress userAddress : userAddresses) {
            addressDTO = new AddressDTO();
            addressDTO.setId(userAddress.getId());
            addressDTO.setName(userAddress.getUserName());
            addressDTO.setPhone(userAddress.getUserPhone());
            addressDTO.setAddress(userAddress.getUserAddress());
            addressDTOS.add(addressDTO);
        }
        return addressDTOS;
    }

    @Override
    public Integer insertAddressInfo(Integer userId, AddressDTO addressDTO) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setUserName(addressDTO.getName());
        userAddress.setUserPhone(addressDTO.getPhone());
        userAddress.setUserAddress(addressDTO.getAddress());
        return userAddressDao.insertAddressInfo(userAddress);
    }

    @Override
    public void updateAddressInfoById(Integer userId, AddressDTO addressDTO) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(addressDTO.getId());
        userAddress.setUserId(userId);
        userAddress.setUserName(addressDTO.getName());
        userAddress.setUserPhone(addressDTO.getPhone());
        userAddress.setUserAddress(addressDTO.getAddress());
        userAddressDao.updateAddressInfoByUIdAndId(userAddress);
    }

    @Override
    public void deleteAddressInfoById(Integer userId, Integer id) {
        userAddressDao.deleteAddressInfoByUIdAndId(userId, id);
    }
}
