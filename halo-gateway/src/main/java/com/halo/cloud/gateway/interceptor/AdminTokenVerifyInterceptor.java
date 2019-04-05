package com.halo.cloud.gateway.interceptor;

import com.auth0.jwt.interfaces.Claim;

import com.halo.cloud.util.TokenUtil;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static com.halo.cloud.gateway.interceptor.UserTokenVerifyInterceptor.outPrint;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/4 21:27
 * @Version 1.0
 */
public class AdminTokenVerifyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        boolean flag = false;
        if (claims != null) {
            int aid = TokenUtil.getId(token, "aid");
            if (TokenUtil.isCloseToExpire(claims)) {
                String newToken = TokenUtil.createToken(aid, "aid");
                response.addHeader("access_token", newToken);
            } else {
                request.setAttribute("aid", aid);
                flag = true;
            }
        } else {
            outPrint(response);
        }
        return flag;
    }
}
