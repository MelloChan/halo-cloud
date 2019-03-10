package com.halo.cloud.forum.server.dao;

import com.halo.cloud.entity.forum.Topic;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/10 22:55
 * @Version 1.0
 */
@Repository
public interface TopicDao {

    @Select("SELECT * FROM hl_topic ORDER BY  gmt_create,gmt_updated DESC")
    List<Topic> listAllTopic();

    @Select("SELECT * FROM hl_topic WHERE type_id = #{typeId} ORDER BY gmt_create,gmt_updated DESC")
    List<Topic> getTopicByTypeId(@Param("typeId") Short typeId);

    @Insert("INSERT INTO hl_topic(`user_id`,`type_id`,`title`,`content`,`gmt_create`,`gmt_updated`)" +
            "VALUES(#{userId},#{typeId},#{title},#{content},NOW(),NOW())")
    boolean insertTopic(Topic topic);

    @Update("UPDATE hl_topic SET content = #{content} WHERE id = #{id} AND gmt_updated = NOW()")
    boolean updateTopic(Topic topic);

    @Delete("DELETE FROM hl_topic WHERE id = #{id}")
    boolean delTopic(@Param("id") Integer id);

}
