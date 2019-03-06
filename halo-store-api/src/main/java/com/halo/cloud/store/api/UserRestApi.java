package com.halo.cloud.store.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("HALO-STORE-SERVER")
public interface UserRestApi {
}
