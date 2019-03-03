package conf;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 短信服务配置
 *
 * @author MelloChan
 * @date 2018/5/10
 */
@Component
public class Ucpaas {

    @Value("${ucpaas.sid}")
    private String sid;

    @Value("${ucpaas.token}")
    private String token;

    @Value("${ucpaas.appid}")
    private String appid;

    private String templateid;
    private String param;
    private String mobile;

    @Value("${ucpaas.url}")
    private String url;

    public Ucpaas() {
    }

    public Ucpaas(String sid, String token, String appid, String templateid, String param, String mobile, String url) {
        this.sid = sid;
        this.token = token;
        this.appid = appid;
        this.templateid = templateid;
        this.param = param;
        this.mobile = mobile;
        this.url = url;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Ucpaas{" +
                "sid='" + sid + '\'' +
                ", token='" + token + '\'' +
                ", appid='" + appid + '\'' +
                ", templateid='" + templateid + '\'' +
                ", param='" + param + '\'' +
                ", mobile='" + mobile + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
