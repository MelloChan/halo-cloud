package util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import conf.QiNiu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author MelloChan
 * @date 2017/6/15
 * 上传文件工具类
 */
public class UploadUtil {
    private final static Logger LOG = LoggerFactory.getLogger(UploadUtil.class);

    private UploadUtil() {
    }

    /**
     * 七牛云图片上传
     * @param qiNiu 七牛云配置类
     * @param buffer 图片数据
     * @return 图片URL
     */
    public static String uploadToQiNiuYun(QiNiu qiNiu, byte[] buffer) {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = qiNiu.getAccessKey();
        String secretKey = qiNiu.getSecretKey();
        String bucket = qiNiu.getBucket();
        String cname = qiNiu.getCname();
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = Arrays.hashCode(buffer) + "";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(buffer, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            LOG.info("key={}", putRet.key);
            LOG.info("hahs={}", putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            LOG.error(r.toString());
            try {
                LOG.error(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return cname + "/" + key;
    }
}
