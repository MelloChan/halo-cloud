package com.halo.cloud.forum.server.dao;

import com.halo.cloud.dto.forum.TopicDetailDto;
import com.halo.cloud.dto.forum.TopicDto;
import com.halo.cloud.entity.forum.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/10 22:55
 * @Version 1.0
 */
@Mapper
public interface TopicDao {

    @Select("SELECT ht.id AS topicId,ht.title AS title,ht.user_id AS userId, " +
            "ht.type_id AS typeId,htt.type_name AS typeName,ht.gmt_create " +
            "FROM hl_topic ht LEFT JOIN hl_topic_type htt ON ht.type_id = htt.id " +
            "ORDER BY ht.gmt_create DESC LIMIT #{limit},#{count}")
    List<TopicDto> getTopicByPage(@Param("limit") int limit, @Param("count") int count);

    @Select("SELECT ht.id AS topicId,ht.title AS title,ht.user_id AS userId, " +
            "ht.type_id AS typeId,htt.type_name AS typeName,ht.gmt_create " +
            "FROM hl_topic ht LEFT JOIN hl_topic_type htt ON ht.type_id = htt.id " +
            "WHERE ht.type_id = #{typeId} AND `status` = 0 ORDER BY ht.gmt_create DESC LIMIT #{limit},#{count} ")
    List<TopicDto> getTopicByTypeIdAndPage(@Param("typeId") int typeId, @Param("limit") int limit, @Param("count") int count);

    @Select("SELECT ht.id AS topicId,ht.type_id AS typeId,htt.type_name AS typeName," +
            "ht.id AS title,ht.content AS content,ht.user_id AS userId,DATE_FORMAT(ht.gmt_updated,'%Y-%m-%d %T') AS updateTime " +
            "FROM hl_topic ht LEFT JOIN hl_topic_type htt ON ht.type_id = htt.id " +
            "WHERE ht.id=#{topicId} AND `status` = 0")
    TopicDetailDto getTopicByTopicId(@Param("topicId") int topicId);

    @Select("SELECT * FROM hl_topic WHERE `status` = 0 ORDER BY  gmt_create,gmt_updated DESC")
    List<Topic> listAllTopic();

    @Select("SELECT * FROM hl_topic WHERE type_id = #{typeId} AND `status` = 0 ORDER BY gmt_create,gmt_updated DESC")
    List<Topic> getTopicByTypeId(@Param("typeId") Short typeId);

    @Select("SELECT COUNT(*) FROM hl_topic WHERE `status` = 0")
    int countTopic();

    @Select("SELECT COUNT(*) FROM hl_topic WHERE `status` = 0 AND type_id =#{typeId}")
    int countTopicByTypeId(@Param("typeId") int typeId);

    @Insert("INSERT INTO hl_topic(`user_id`,`type_id`,`title`,`content`,`gmt_create`,`gmt_updated`)" +
            "VALUES(#{userId},#{typeId},#{title},#{content},NOW(),NOW())")
    int insertTopic(Topic topic);

    @Update("UPDATE hl_topic SET content = #{content},gmt_updated = NOW() WHERE id = #{id} AND `status` = 0")
    int updateTopic(Topic topic);

    @Delete("UPDATE hl_topic SET `status` = #{status} WHERE id = #{id}")
    int updateTopicStatus(@Param("status") int status, @Param("id") Integer id);

}
