package com.halo.cloud.forum.server.service.impl;

import com.halo.cloud.dto.forum.*;
import com.halo.cloud.dto.store.UserProfileInfoDTO;
import com.halo.cloud.entity.forum.Topic;
import com.halo.cloud.entity.forum.TopicBack;
import com.halo.cloud.entity.forum.TopicNotify;
import com.halo.cloud.forum.server.dao.BackDao;
import com.halo.cloud.forum.server.dao.NotifyDao;
import com.halo.cloud.forum.server.dao.TopicDao;
import com.halo.cloud.forum.server.service.TopicService;
import com.halo.cloud.store.api.UserRestApi;
import com.halo.cloud.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/1 10:41
 * @Version 1.0
 */
@Service
public class TopicServiceImpl implements TopicService {

    private static final Logger log = LoggerFactory.getLogger(TopicServiceImpl.class);

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private BackDao backDao;

    @Autowired
    private NotifyDao notifyDao;

    @Autowired
    private UserRestApi userRestApi;

    @Override
    public TopicListDto getTopicListByPage(int limit, int count) {
        limit = (limit - 1) * count;
        try {
            List<TopicDto> topics = topicDao.getTopicByPage(limit, count);
            TopicListDto topicList = fillTopics(topics);
            int cnt = topicDao.countTopic();
            topicList.setCount(cnt);
            return topicList;
        } catch (Exception e) {
            log.error("[getTopicListByPage] error:{}", e, e.getMessage());
        }
        return null;
    }

    @Override
    public TopicListDto getTopicListByTypeId(int typeId, int limit, int count) {
        limit = (limit - 1) * count;
        try {
            List<TopicDto> topics = topicDao.getTopicByTypeIdAndPage(typeId, limit, count);
            TopicListDto topicList = fillTopics(topics);
            int cnt = topicDao.countTopicByTypeId(typeId);
            topicList.setCount(cnt);
            return topicList;
        } catch (Exception e) {
            log.error("[getTopicListByTypeId] error:{}", e, e.getMessage());
        }
        return null;
    }

    private TopicListDto fillTopics(List<TopicDto> topics) {
        TopicListDto topicList = new TopicListDto();
        for (TopicDto topic : topics) {
            UserProfileInfoDTO topicUser = userRestApi.getUserProfileInfoByUid(topic.getUserId());
            topic.setUserName(topicUser.getUsername());
            topic.setAvatar(topicUser.getAvatar());

            TopicBack lastBack = backDao.getLastBackUidByTopicId(topic.getTopicId());
            if (Objects.isNull(lastBack)) {
                continue;
            }
            String lastTime = TimeUtil.formatDateTime(lastBack.getGmtCreate());
            UserProfileInfoDTO lastBackUser = userRestApi.getUserProfileInfoByUid(lastBack.getUserId());
            topic.setLastBack(lastBackUser.getUsername());
            topic.setLastTime(lastTime);

            int backCount = backDao.countBackNumberByTopicId(topic.getTopicId());
            topic.setBackNumber(backCount);
        }
        topicList.setTopics(topics);
        return topicList;
    }

    @Override
    public TopicDetailDto getTopicDetailByTopicId(int topicId, int limit, int count) {
        try {
            TopicDetailDto topicDetail = topicDao.getTopicByTopicId(topicId);

            UserProfileInfoDTO topicUser = userRestApi.getUserProfileInfoByUid(topicDetail.getUserId());
            topicDetail.setAvatar(topicUser.getAvatar());
            topicDetail.setUserName(topicUser.getUsername());

            TopicBack lastBack = backDao.getLastBackUidByTopicId(topicId);
            if (!Objects.isNull(lastBack)) {
                topicDetail.setLastTime(TimeUtil.formatDateTime(lastBack.getGmtCreate()));

                int backCount = backDao.countBackNumberByTopicId(topicId);
                topicDetail.setBackNumber(backCount);

                List<BackDto> backs = backDao.getBackDtoByTopicIdAndPage(topicId, limit, count);
                topicDetail.setBackList(backs);
            }
            return topicDetail;
        } catch (Exception e) {
            log.error("[getTopicDetailByTopicId] error:{}", e, e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insertTopic(Topic topic) {
        try {
            int row = topicDao.insertTopic(topic);
            return row == 1;
        } catch (Exception e) {
            log.error("[insertTopic] error:{}", e, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateTopic(Topic topic) {
        try {
            int row = topicDao.updateTopic(topic);
            return row == 1;
        } catch (Exception e) {
            log.error("[updateTopic] error:{}", e, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delTopicByTopicId(int topicId) {
        try {
            int row = topicDao.updateTopicStatus(-1, topicId);
            return row == 1;
        } catch (Exception e) {
            log.error("[delTopic] error:{}", e, e.getMessage());
        }
        return false;
    }

    /*    ----- 主题回复 ----     */

    @Override
    public int getBackNumber(int userId) {
        try {
            return notifyDao.countNotify(userId);
        } catch (Exception e) {
            log.error("[getBackNumber] error:{}", e, e.getMessage());
        }
        return 0;
    }

    @Override
    public BackMsgListDto getBackMsgListByUserId(int userId) {
        try {
            List<BackMsgDto> backMsgs = notifyDao.getBackNotifyByUserId(userId);
            notifyDao.updateNotifyStatus(-1, userId);
            BackMsgListDto backMsgList = new BackMsgListDto();
            backMsgList.setBacks(backMsgs);
            return backMsgList;
        } catch (Exception e) {
            log.error("[getBackMsgListByUserId] error:{}", e, e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insertBack(BackReq backReq) {
        TopicBack back = new TopicBack();
        back.setTopicId(backReq.getTopicId());
        back.setUserId(backReq.getSender());
        back.setContent(backReq.getContent());
        List<Integer> ids = backReq.getReceivers();
        try {
            backDao.insertBack(back);
            if (ids.size() == 1) {
                TopicNotify notify = new TopicNotify();
                notify.setTopicId(backReq.getTopicId());
                notify.setSender(backReq.getSender());
                notify.setReceiver(ids.get(0));
                notifyDao.insertNotify(notify);
            } else {
                List<TopicNotify> notifies = new ArrayList<>();
                TopicNotify notify = new TopicNotify();
                for (int id : ids) {
                    notify.setTopicId(backReq.getTopicId());
                    notify.setSender(backReq.getSender());
                    notify.setReceiver(id);
                    notifies.add(notify);
                }
                notifyDao.batchInsert(notifies);
            }
            return true;
        } catch (Exception e) {
            log.error("[insertBack] error:{}", e, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delBackByBackId(int backId) {
        try {
            int row = backDao.updateBackStatus(-1, backId);
            return row == 1;
        } catch (Exception e) {
            log.error("[delBackByBackId] error:{}", e, e.getMessage());
        }
        return false;
    }


}
