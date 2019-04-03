package com.halo.cloud.forum.server.web;

import com.halo.cloud.dto.Result;
import com.halo.cloud.dto.forum.TopicDetailDto;
import com.halo.cloud.dto.forum.TopicDto;
import com.halo.cloud.entity.forum.Topic;
import com.halo.cloud.forum.api.TopicRestApi;
import com.halo.cloud.forum.server.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/1 10:40
 * @Version 1.0
 */
@Controller
public class TopicController implements TopicRestApi {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public Result<List<TopicDto>> allTopicList() {
        return null;
    }

    @Override
    public Result<List<TopicDto>> getTopicListByTypeId(Integer typeId) {
        return null;
    }

    @Override
    public Result<TopicDetailDto> getTopicDetailByTopicId(Integer topicId) {
        return null;
    }

    @Override
    public Result<Boolean> insertTopic(Topic topic) {
        return null;
    }

    @Override
    public Result<Boolean> updateTopic(Topic topic) {
        return null;
    }

    @Override
    public Result<Boolean> delTopicByTopicId(Integer topicId) {
        return null;
    }

    @Override
    public Result<Integer> getBackNumber(Integer userId) {
        return null;
    }
}
