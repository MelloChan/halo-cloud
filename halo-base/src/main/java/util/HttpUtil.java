package util;

import okhttp3.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * HTTP请求工具
 *
 * @author MelloChan
 * @date 2018/5/4
 */
public class HttpUtil {
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
    private static volatile HttpUtil httpUtil;
    private OkHttpClient client;

    private HttpUtil() {
        client = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public static HttpUtil getInstance() {
        if (httpUtil == null) {
            synchronized (HttpUtil.class) {
                if (httpUtil == null) {
                    httpUtil = new HttpUtil();
                }
            }
        }
        return httpUtil;
    }

    /**
     * 带参数的get请求
     *
     * @param url    请求的标识符
     * @param params 参数
     */
    public String requestGet(String url, Map<String, String> params) {
        String respBody = null;
        try {
            String string = addParams(params);
            //补全地址
            String requestUrl = String.format("%s?%s", url, string);
            Request request = addHeaders().url(requestUrl).build();
            Response response = client.newCall(request).execute();
            respBody = response.body().string();
        } catch (IOException e) {
            System.out.println("GET请求异常:" + e.getMessage());
            e.printStackTrace();
        }
        return respBody;
    }

    /**
     * 带Json参数的post请求
     *
     * @param url  请求的标识符
     * @param json 参数
     */
    public String requestPostByJson(String url, String json) {
        String respBody = null;
        try {
//            String string = addParams(params);
            String requestUrl = String.format("%s", url);
            RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, json);
            Request request = addHeaders().url(requestUrl).post(requestBody).build();
            Response response = client.newCall(request).execute();
            respBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respBody;
    }

    public String requestPostByForm(String url, Map<String, String> params) {
        String respBody = null;
        try {
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
            RequestBody requestBody = builder.build();
            String requestUrl = String.format("%s", url);
            Request request = addHeaders().url(requestUrl).post(requestBody).build();
            Response response = client.newCall(request).execute();
            respBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respBody;
    }

    /**
     * 补全参数
     *
     * @param params 参数列表
     * @return 返回完整参数
     * @throws UnsupportedEncodingException 编码类型不支持
     */
    public String addParams(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        for (String key : params.keySet()) {
            if (pos > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s", key, URLEncoder.encode(params.get(key), "UTF-8")));
            pos++;
        }
        return sb.toString();
    }

    /**
     * 统一为请求添加头信息
     *
     * @return 返回请求头信息
     */
    public Request.Builder addHeaders() {
        return new Request.Builder()
                .addHeader("Connection", "keep-alive");
    }
}
