package com.halo.cloud.forum.server.dao;

import com.halo.cloud.entity.forum.TopicType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/5 21:06
 * @Version 1.0
 */
@Mapper
public interface TypeDao {
    @Select("SELECT * FROM hl_topic_type")
    List<TopicType> allTopicType();

    @Insert("INSERT INTO hl_topic_type(`type_name`)VALUES(#{typeName})")
    int insert(TopicType topicType);

    @Update("UPDATE hl_topic_type SET type_name = #{typeName} WHERE id = #{id}")
    int update(TopicType topicType);
}
