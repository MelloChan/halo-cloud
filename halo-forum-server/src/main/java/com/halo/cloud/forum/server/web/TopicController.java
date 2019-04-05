package com.halo.cloud.forum.server.web;

import com.halo.cloud.dto.Result;
import com.halo.cloud.dto.forum.BackMsgListDto;
import com.halo.cloud.dto.forum.BackReq;
import com.halo.cloud.dto.forum.TopicDetailDto;
import com.halo.cloud.dto.forum.TopicListDto;
import com.halo.cloud.dto.store.UserProfileInfoDTO;
import com.halo.cloud.entity.forum.Topic;
import com.halo.cloud.entity.forum.TopicType;
import com.halo.cloud.forum.api.TopicRestApi;
import com.halo.cloud.forum.server.service.TopicService;
import com.halo.cloud.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
    private static HttpServletRequest request;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }


    @ModelAttribute
    public void init(HttpServletRequest request) {
        TopicController.request = request;
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
    public Result<List<TopicType>> getTopicTypeList() {
        List<TopicType> types = topicService.getAllTopicType();
        Result<List<TopicType>> result = Result.success();
        result.setData(types);
        return result;
    }

    @Override
    public Result<Boolean> insertTopic(@RequestBody Topic topic) {
        try {
            int uid = TokenUtil.getId(request.getHeader("access_token"), "uid");
            topic.setUserId(uid);
            boolean flag = topicService.insertTopic(topic);
            return flag ? Result.success() : Result.error();
        } catch (Exception e) {
            log.error("[insertTopic] error:{}", topic, e, e.getMessage());
            Result result = Result.error();
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Result<Boolean> updateTopic(@RequestBody Topic topic) {
        try {
            int uid = TokenUtil.getId(request.getHeader("access_token"), "uid");
            topic.setUserId(uid);
            boolean flag = topicService.updateTopic(topic);
            return flag ? Result.success() : Result.error();
        } catch (Exception e) {
            log.error("[updateTopic] error:{}", topic, e, e.getMessage());
            Result result = Result.error();
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Result<Boolean> delTopicByTopicId(@PathVariable("topicId") int topicId) {
        try {
            int uid = TokenUtil.getId(request.getHeader("access_token"), "uid");
            boolean flag = topicService.delTopicByTopicId(topicId, uid);
            return flag ? Result.success() : Result.error();
        } catch (Exception e) {
            log.error("[delTopic] error:{}", topicId, e, e.getMessage());
            Result result = Result.error();
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Result<Integer> getBackNumber(@RequestParam("uid") int uid) {
        try {
            Result result = Result.success();
            result.setData(topicService.getBackNumber(uid));
            return result;
        } catch (Exception e) {
            log.error("[getBackNumber] error:{}", e, e.getMessage());
            Result result = Result.error();
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Result<BackMsgListDto> getBackMsgListByUserId() {
        try {
            int uid = TokenUtil.getId(request.getHeader("access_token"), "uid");
            BackMsgListDto backMsgListDto = topicService.getBackMsgListByUserId(uid);
            Result result = Result.success();
            result.setData(backMsgListDto);
            return result;
        } catch (Exception e) {
            log.error("[getBackMsgListByUserId] error:{}", e, e.getMessage());
            Result result = Result.error();
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Result<Boolean> insertBack(@RequestBody BackReq backReq) {
        try {
            int uid = TokenUtil.getId(request.getHeader("access_token"), "uid");
            backReq.setSender(uid);
            boolean flag = topicService.insertBack(backReq);
            return flag ? Result.success() : Result.error();
        } catch (Exception e) {
            log.error("[insertBack] error:{}", backReq, e, e.getMessage());
            Result result = Result.error();
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Result<Boolean> delBackByBackId(@PathVariable("backId") int backId) {
        try {
            int uid = TokenUtil.getId(request.getHeader("access_token"), "uid");
            boolean flag = topicService.delBackByBackId(backId, uid);
            return flag ? Result.success() : Result.error();
        } catch (Exception e) {
            log.error("[delBackByBackId] error:{}", backId, e, e.getMessage());
            Result result = Result.error();
            result.setMessage(e.getMessage());
            return result;
        }
    }
}
