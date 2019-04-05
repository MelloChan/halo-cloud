package com.halo.cloud.gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import org.springframework.stereotype.Component;




/**
 * Created by mellochan on 2019/04/03.
 */
@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -1000;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
