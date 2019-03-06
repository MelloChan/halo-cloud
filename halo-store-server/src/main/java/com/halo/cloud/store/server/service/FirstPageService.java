package com.halo.cloud.store.server.service;


import com.halo.cloud.dto.FirstPageInfoDTO;

/**
 * @author SAIKAII
 * @date 2018/6/17
 */
public interface FirstPageService {

    /**
     * 获得首页所需信息
     */
    FirstPageInfoDTO getFirstPageInfo();
}
