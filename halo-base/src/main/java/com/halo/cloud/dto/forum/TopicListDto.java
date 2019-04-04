package com.halo.cloud.dto.forum;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/3 16:14
 * @Version 1.0
 */
public class TopicListDto implements Serializable {
    private List<TopicDto> topics;
    private Integer count;

    public List<TopicDto> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicDto> topics) {
        this.topics = topics;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TopicListDto{" +
                "topics=" + topics +
                ", count=" + count +
                '}';
    }
}
