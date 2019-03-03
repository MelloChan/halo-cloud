package com.halo.cloud.server.service.impl;


import com.halo.cloud.server.dao.OrderDao;
import com.halo.cloud.server.dao.ProductDao;
import com.halo.cloud.server.service.FirstPageService;
import dto.FirstPageInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SAIKAII
 * @date 2018/6/17
 */
@Service
public class FirstPageServiceImpl implements FirstPageService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public FirstPageInfoDTO getFirstPageInfo() {
        return new FirstPageInfoDTO(
                orderDao.getNumOfOrder(),
                orderDao.getNumOfNoHandledOrder(),
                productDao.getNumOfZeroStock(),
                orderDao.getTotalTurnOver(),
                orderDao.getMeiZuSales(),
                orderDao.getMeiLanSales());
    }

}
