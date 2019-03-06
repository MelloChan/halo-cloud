package com.halo.cloud.forum.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("HALO-FORUM-SERVER")
public interface TopicRestApi {
}
