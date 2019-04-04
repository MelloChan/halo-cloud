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

    @Select("SELECT user_id,gmt_create FROM hl_topic_back WHERE topic_id = #{topicId} AND `status` = 0 ORDER BY gmt_create DESC LIMIT 1")
    TopicBack getLastBackUidByTopicId(@Param("topicId") int topicId);

    @Select("SELECT id AS backId,user_id AS userId,content AS content,DATE_FORMAT(gmt_create,'%Y-%m-%d %T') AS backTime " +
            "hup.username AS userName,hup.avatar AS avatar,htb.gmt_create " +
            "FROM hl_topic_back htb LEFT JOIN hl_user_profile hup ON htb.user_id = hup.user_id " +
            "WHERE topic_id=#{topicId} AND `status` = 0 ORDER BY htb.gmt_create LIMIT #{limit},#{count}")
    List<BackDto> getBackDtoByTopicIdAndPage(@Param("topicId") int topicId, @Param("limit") int limit, @Param("count") int count);

    @Select("SELECT COUNT(*) FROM hl_topic_back WHERE topic_id = #{topicId} AND `status` = 0")
    int countBackNumberByTopicId(@Param("topicId") int topicId);

    @Delete("UPDATE hl_topic_back SET `status` = #{status} WHERE id = #{id}")
    int updateBackStatus(@Param("status") int status, @Param("id") int id);

    @Insert("INSERT INTO hl_topic_back(`user_id`,`topic_id`,`content`,`gmt_create`,`gmt_updated`)" +
            "VALUES(#{userId},#{topicId},#{content},NOW(),NOW())")
    void insertBack(TopicBack back);
}
