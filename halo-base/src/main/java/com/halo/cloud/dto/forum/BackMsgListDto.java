package com.halo.cloud.dto.forum;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/3 20:45
 * @Version 1.0
 */
public class BackMsgListDto {
    private List<BackMsgDto> backs;

    public List<BackMsgDto> getBacks() {
        return backs;
    }

    public void setBacks(List<BackMsgDto> backs) {
        this.backs = backs;
    }

    @Override
    public String toString() {
        return "BackMsgListDto{" +
                "backs=" + backs +
                '}';
    }
}
