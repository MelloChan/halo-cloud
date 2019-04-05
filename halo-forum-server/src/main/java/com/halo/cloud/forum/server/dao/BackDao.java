package com.halo.cloud.forum.server.dao;

import com.halo.cloud.dto.forum.BackDto;
import com.halo.cloud.entity.forum.TopicBack;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/10 22:57
 * @Version 1.0
 */
@Mapper
public interface BackDao {

    @Select("SELECT user_id AS userId,gmt_create AS gmtCreate FROM hl_topic_back WHERE topic_id = #{topicId} AND `status` = 0 ORDER BY gmt_create DESC LIMIT 1")
    TopicBack getLastBackUidByTopicId(@Param("topicId") int topicId);

    @Select("SELECT htb.id AS backId,htb.user_id AS userId,htb.content AS content,DATE_FORMAT(htb.gmt_create,'%Y-%m-%d %T') AS backTime, " +
            "hup.username AS userName,hup.avatar AS avatar,htb.gmt_create " +
            "FROM hl_topic_back htb LEFT JOIN hl_user_profile hup ON htb.user_id = hup.user_id " +
            "WHERE topic_id=#{topicId} AND `status` = 0 ORDER BY htb.gmt_create")
    List<BackDto> getBackDtoByTopicIdAndPage(@Param("topicId") int topicId);

    @Select("SELECT COUNT(*) FROM hl_topic_back WHERE topic_id = #{topicId} AND `status` = 0")
    int countBackNumberByTopicId(@Param("topicId") int topicId);

    @Delete("UPDATE hl_topic_back SET `status` = #{status} WHERE id = #{id} AND user_id = #{userId}")
    int updateBackStatus(@Param("status") int status, @Param("id") int id, @Param("userId") int userId);

    @Insert("INSERT INTO hl_topic_back(`user_id`,`topic_id`,`content`,`gmt_create`,`gmt_updated`)" +
            "VALUES(#{userId},#{topicId},#{content},NOW(),NOW())")
    void insertBack(TopicBack back);
}
