package com.halo.cloud.forum.server.dao;

import com.halo.cloud.dto.forum.BackMsgDto;
import com.halo.cloud.entity.forum.TopicNotify;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/13 21:48
 * @Version 1.0
 */
@Mapper
public interface NotifyDao {

    @Select("SELECT htn.topic_id AS topicId,htn.sender AS senderId,htb.id AS backId,htb.content AS content," +
            "DATE_FORMAT(htb.gmt_create,'%Y-%m-%d %T') AS createTime ,ht.title AS title,hup.username as senderName " +
            "FROM hl_topic_notify htn LEFT JOIN hl_topic_back htb ON htn.topic_id = htb.topic_id " +
            "AND htn.sender=htb.user_id LEFT JOIN hl_topic ht " +
            "ON ht.id=htb.topic_id LEFT JOIN hl_user_profile hup ON hup.user_id = htb.user_id " +
            "WHERE receiver = #{userId} AND htb.`status` = 0 AND ht.`status` = 0")
    List<BackMsgDto> getBackNotifyByUserId(@Param("userId") int userId);

    @Select("SELECT * FROM hl_topic_notify WHERE `status` = 0")
    List<TopicNotify> allNotify();

    @Select("SELECT COUNT(*) FROM hl_topic_notify WHERE receiver = #{userId} `status` = 0")
    int countNotify(@Param("userId") int userId);

    @Insert("INSERT INTO hl_topic_notify(topic_id,sender,receiver)VALUES(#{topicId},#{sender},#{receiver})")
    int insertNotify(TopicNotify notify);

    @Insert("<script>" +
            " INSERT INTO hl_topic_notify(topic_id,sender,receiver) VALUES " +
            "<foreach collection = 'notifyList' item = 'nt' index='index' separator=','>" +
            "(#{nt.topicId},#{nt.sender},#{nt.receiver})" +
            "</foreach>" +
            "</script>")
    int batchInsert(@Param("notifyList") List<TopicNotify> notifyList);

    @Update("UPDATE hl_topic_notify SET `status` = #{status} WHERE receiver = #{userId} AND gmt_create < NOW() AND `status` = 0")
    int updateNotifyStatus(@Param("status") int status, @Param("userId") int userId);
}
