package com.halo.cloud.forum.server.dao;

import com.halo.cloud.entity.forum.Back;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/10 22:57
 * @Version 1.0
 */
@Repository
public interface BackDao {

    @Select("SELECT * FROM hl_back")
    List<Back> listAll();

    @Select("SELECT * FROM hl_back WHERE topic_id =#{topicId} ")
    List<Back> getBackByTopicId(@Param("topicId") Integer topicId);

    @Delete("DELETE FROM hl_back WHERE id = #{id}")
    boolean delBack(@Param("id") Integer id);

    @Insert("INSERT INTO hl_back(`user_id`,`topic_id`,`content`,`gmt_create`,`gmt_updated`)" +
            "VALUES(#{userId},#{topicId},#{content},NOW(),NOW())")
    boolean insertBack(Back back);
}
