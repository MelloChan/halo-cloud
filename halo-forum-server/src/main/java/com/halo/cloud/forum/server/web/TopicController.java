package com.halo.cloud.forum.server.web;

import com.halo.cloud.dto.Result;
import com.halo.cloud.dto.forum.BackMsgListDto;
import com.halo.cloud.dto.forum.BackReq;
import com.halo.cloud.dto.forum.TopicDetailDto;
import com.halo.cloud.dto.forum.TopicListDto;
import com.halo.cloud.dto.store.UserProfileInfoDTO;
import com.halo.cloud.entity.forum.Topic;
import com.halo.cloud.forum.api.TopicRestApi;
import com.halo.cloud.forum.server.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/1 10:40
 * @Version 1.0
 */
@RestController
public class TopicController implements TopicRestApi {

    private static final Logger log = LoggerFactory.getLogger(TopicController.class);
    private final TopicService topicService;


    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }



    @Override
    public Result<TopicListDto> getTopicListByPage(@RequestParam("limit") int limit, @RequestParam("count") int count) {
        TopicListDto topics = topicService.getTopicListByPage(limit, count);
        if (Objects.isNull(topics)) {
            log.error("[getTopicListByPage] topics is null!");
            return Result.error();
        }
        Result<TopicListDto> result = Result.success();
        result.setData(topics);
        return result;
    }

    @Override
    public Result<TopicListDto> getTopicListByTypeId(@PathVariable("typeId") int typeId, @RequestParam("limit") int limit, @RequestParam("count") int count) {
        TopicListDto topics = topicService.getTopicListByTypeId(typeId, limit, count);
        Result<TopicListDto> result = Result.success();
        result.setData(topics);
        return result;
    }

    @Override
    public Result<TopicDetailDto> getTopicDetailByTopicId(@PathVariable("topicId") int topicId, @RequestParam("limit") int limit, @RequestParam("count") int count) {
        TopicDetailDto topicDetail = topicService.getTopicDetailByTopicId(topicId, limit, count);
        Result<TopicDetailDto> result = Result.success();
        result.setData(topicDetail);
        return result;
    }

    @Override
    public Result<Boolean> insertTopic(@RequestBody Topic topic) {
        boolean flag = topicService.insertTopic(topic);
        return flag ? Result.success() : Result.error();
    }

    @Override
    public Result<Boolean> updateTopic(@RequestBody Topic topic) {
        boolean flag = topicService.updateTopic(topic);
        return flag ? Result.success() : Result.error();
    }

    @Override
    public Result<Boolean> delTopicByTopicId(@PathVariable("topicId") int topicId) {
        boolean flag = topicService.delTopicByTopicId(topicId);
        return flag ? Result.success() : Result.error();
    }

    @Override
    public Result<Integer> getBackNumber(@PathVariable("userId") int userId) {
        Result result = Result.success();
        result.setData(topicService.getBackNumber(userId));
        return result;
    }

    @Override
    public Result<BackMsgListDto> getBackMsgListByUserId(@PathVariable("userId") int userId) {
        BackMsgListDto backMsgListDto=topicService.getBackMsgListByUserId(userId);
        Result result = Result.success();
        result.setData(backMsgListDto);
        return result;
    }

    @Override
    public Result<Boolean> insertBack(@RequestBody BackReq backReq) {
        boolean flag = topicService.insertBack(backReq);
        return flag ? Result.success() : Result.error();
    }

    @Override
    public Result<Boolean> delBackByBackId(@PathVariable("backId") int backId) {
        boolean flag = topicService.delBackByBackId(backId);
        return flag ? Result.success() : Result.error();
    }
}
