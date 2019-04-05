package com.halo.cloud.gateway.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.google.gson.JsonObject;
import com.halo.cloud.util.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author MelloChan
 * @date 2018/5/1
 */
public class UserTokenVerifyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        String token = httpServletRequest.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        boolean flag = false;
        if (claims != null) {
            int uid = TokenUtil.getId(token, "uid");
            if (TokenUtil.isCloseToExpire(claims)) {
                String newToken = TokenUtil.createToken(uid, "uid");
                httpServletResponse.addHeader("access_token", newToken);
            } else {
                httpServletRequest.setAttribute("uid", uid);
                flag = true;
            }
        } else {
            outPrint(httpServletResponse);
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

    static void outPrint(HttpServletResponse httpServletResponse) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("errCode", "40008");
        jsonObject.addProperty("msg", "无效的token");
        PrintWriter out = httpServletResponse.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
