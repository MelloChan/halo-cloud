package com.halo.cloud.server.service;


import com.halo.cloud.server.conf.Email;
import com.halo.cloud.server.conf.Ucpaas;
import com.halo.cloud.server.util.EmailUtil;
import com.halo.cloud.server.util.RedisUtil;
import com.halo.cloud.server.util.SmsUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.*;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * @author MelloChan
 * @date 2018/5/26
 */
@Service
public class AuthService {
    @Autowired
    private Ucpaas ucpaas;
    @Autowired
    private Email email;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 发送短信验证码 本地验证码存入缓存 60s内过期
     *
     * @param phone  用户手机号
     * @param tempId 短信模板Id
     * @return 发送成功否
     */
    public boolean sendSmsCode(String phone, String tempId) {
        String code = VerifyCodeGenerator.getFourVerifyCode();
        redisUtil.add(phone, 60L, code);
        ucpaas = new Ucpaas(ucpaas.getSid(), ucpaas.getToken(), ucpaas.getAppid(), tempId, code, phone, ucpaas.getUrl());
        String json = SmsUtil.sendSms(ucpaas);
        int okIdx = json.indexOf("OK");
        return okIdx >= 0;
    }

    /**
     * 发送邮箱验证码 本地验证码输入缓存 30分钟过去
     *
     * @param destinationEmail 目的邮箱
     * @throws GeneralSecurityException 安全异常
     * @throws MessagingException       消息异常
     */
    public void sendEmail(String destinationEmail) throws GeneralSecurityException, MessagingException {
        String code = VerifyCodeGenerator.getSixVerifyCode();
        redisUtil.add(destinationEmail, 1800L, code);
        String msg = "您好：\n" +
                "感谢您使用Halo.服务。\n" +
                "您正在进行Halo. 账号邮箱操作，请在30分钟内将此验证码：" + code + " 输入验证码输入框，以完成验证。\n" +
                "此致\n" +
                "Halo.科技";
        EmailUtil.sendEmail(email, msg, destinationEmail);
    }

    /**
     * 验证手机号码是否注册过
     *
     * @param phone 用户手机号
     * @return 是否注册过
     */
    public boolean verifyPhone(String phone) {
        return userInfoService.getIdByPhone(phone) != null;
    }

    /**
     * 验证用户名是否被注册过
     *
     * @param username 用户名
     * @return 是否已被使用
     */
    public boolean verifyUsername(String username) {
        return userInfoService.getIdByUsername(username) != null;
    }

    /**
     * 验证邮箱是否被绑定
     *
     * @param email 邮箱
     * @return 是否已被绑定
     */
    public boolean verifyEmail(String email) {
        return userInfoService.getIdByEmail(email) != null;
    }

    /**
     * 验证手机验证码是否正确
     *
     * @param phone 用户手机号
     * @param code  用户发来的验证码
     * @return 是否正确
     */
    public boolean verifyCode(String phone, String code) {
        return code.equals(redisUtil.get(phone));
    }

    /**
     * 验证邮箱验证码是否正确
     *
     * @param email 用户邮箱
     * @param code  邮箱验证码
     * @return 是否正确
     */
    public boolean verifyEmailCode(String email, String code) {
        return code.equals(redisUtil.get(email));
    }
}
