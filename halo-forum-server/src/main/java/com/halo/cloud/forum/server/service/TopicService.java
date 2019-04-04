package com.halo.cloud.forum.server.service;

import com.halo.cloud.dto.forum.BackMsgListDto;
import com.halo.cloud.dto.forum.BackReq;
import com.halo.cloud.dto.forum.TopicDetailDto;
import com.halo.cloud.dto.forum.TopicListDto;
import com.halo.cloud.entity.forum.Topic;


/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/1 10:41
 * @Version 1.0
 */
public interface TopicService {
    TopicListDto getTopicListByPage(int limit, int count);

    TopicListDto getTopicListByTypeId(int typeId, int limit, int count);

    TopicDetailDto getTopicDetailByTopicId(int topicId, int limit, int count);

    boolean insertTopic(Topic topic);

    boolean updateTopic(Topic topic);

    boolean delTopicByTopicId(int topicId);

    int getBackNumber(int userId);

    BackMsgListDto getBackMsgListByUserId(int userId);

    boolean insertBack(BackReq backReq);

    boolean delBackByBackId(int backId);
}
