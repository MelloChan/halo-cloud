package com.halo.cloud.admin.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("HALO-ADMIN-SERVER")
public interface AdminRestApi {
}
