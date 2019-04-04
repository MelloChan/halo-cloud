package com.halo.cloud.forum.api;

import com.halo.cloud.dto.Result;
import com.halo.cloud.dto.forum.BackMsgListDto;
import com.halo.cloud.dto.forum.BackReq;
import com.halo.cloud.dto.forum.TopicDetailDto;
import com.halo.cloud.dto.forum.TopicListDto;
import com.halo.cloud.entity.forum.Topic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("HALO-FORUM-SERVER")
public interface TopicRestApi {

    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    Result<TopicListDto> getTopicListByPage(@RequestParam("limit") int limit, @RequestParam("count") int count);

    @RequestMapping(value = "/topic/{typeId}/type", method = RequestMethod.GET)
    Result<TopicListDto> getTopicListByTypeId(@PathVariable("typeId") int typeId, @RequestParam("limit") int limit, @RequestParam("count") int count);

    @RequestMapping(value = "/topic/{topicId}", method = RequestMethod.GET)
    Result<TopicDetailDto> getTopicDetailByTopicId(@PathVariable("topicId") int topicId, @RequestParam("limit") int limit, @RequestParam("count") int count);

    @RequestMapping(value = "/topic", method = RequestMethod.POST)
    Result<Boolean> insertTopic(@RequestBody Topic topic);

    @RequestMapping(value = "/topic", method = RequestMethod.PUT)
    Result<Boolean> updateTopic(@RequestBody Topic topic);

    @RequestMapping(value = "/topic/{topicId}", method = RequestMethod.DELETE)
    Result<Boolean> delTopicByTopicId(@PathVariable("topicId") int topicId);

    @RequestMapping(value = "/back/number/{userId}", method = RequestMethod.GET)
    Result<Integer> getBackNumber(@PathVariable("userId") int userId);

    @RequestMapping(value = "/back/{userId}",method = RequestMethod.GET)
    Result<BackMsgListDto> getBackMsgListByUserId(@PathVariable("userId") int userId);

    @RequestMapping(value = "/back",method = RequestMethod.POST)
    Result<Boolean> insertBack(BackReq backReq);

    @RequestMapping(value = "/back/{backId}",method = RequestMethod.DELETE)
    Result<Boolean> delBackByBackId(@PathVariable("backId") int backId);
}
