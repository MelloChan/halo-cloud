package com.halo.cloud.forum.api;

import com.halo.cloud.dto.Result;
import com.halo.cloud.dto.forum.TopicDetailDto;
import com.halo.cloud.dto.forum.TopicDto;
import com.halo.cloud.entity.forum.Topic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("HALO-FORUM-SERVER")
public interface TopicRestApi {

    @ResponseBody
    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    Result<List<TopicDto>> allTopicList();

    @ResponseBody
    @RequestMapping(value = "/topic/{typeId}/type", method = RequestMethod.GET)
    Result<List<TopicDto>> getTopicListByTypeId(@PathVariable("typeId") Integer typeId);

    @ResponseBody
    @RequestMapping(value = "/topic/{topicId}", method = RequestMethod.GET)
    Result<TopicDetailDto> getTopicDetailByTopicId(@PathVariable("topicId") Integer topicId);

    @ResponseBody
    @RequestMapping(value = "/topic", method = RequestMethod.POST)
    Result<Boolean> insertTopic(@RequestBody Topic topic);

    @ResponseBody
    @RequestMapping(value = "/topic", method = RequestMethod.PUT)
    Result<Boolean> updateTopic(@RequestBody Topic topic);

    @ResponseBody
    @RequestMapping(value = "/topic/{topicId}", method = RequestMethod.DELETE)
    Result<Boolean> delTopicByTopicId(@PathVariable("topicId") Integer topicId);

    @ResponseBody
    @RequestMapping(value = "/topic/back/number/{userId}", method = RequestMethod.GET)
    Result<Integer> getBackNumber(@PathVariable("userId") Integer userId);
}
