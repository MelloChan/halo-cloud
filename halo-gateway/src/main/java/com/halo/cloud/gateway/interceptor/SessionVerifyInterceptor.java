package com.halo.cloud.gateway.interceptor;

import com.google.gson.JsonObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @author SAIKAII
 * @date 2018/6/12
 */
public class SessionVerifyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        HttpSession session = httpServletRequest.getSession();
        String admin = (String)session.getAttribute("admin");
        if(null != admin){
            session.setMaxInactiveInterval(5*60);
            return true;
        }else{
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errCode", "40019");
            jsonObject.addProperty("msg", "请重新登录");
            PrintWriter out = httpServletResponse.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
