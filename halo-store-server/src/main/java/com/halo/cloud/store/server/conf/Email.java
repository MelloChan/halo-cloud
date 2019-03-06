package com.halo.cloud.store.server.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author MelloChan
 * @date 2018/5/31
 */
@Component
public class Email {

    @Value("${halo.smtp}")
    private String smtp;

    @Value("${halo.email}")
    private String email;

    @Value("${halo.password}")
    private String password;

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Email{" +
                "smtp='" + smtp + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
