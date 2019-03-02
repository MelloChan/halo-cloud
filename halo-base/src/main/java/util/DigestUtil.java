package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 密码盐加密与校验工具
 * @author MelloChan
 * @date 2018/4/30
 */
public class DigestUtil {

    private static MessageDigest md;

    private DigestUtil() {
    }

    static {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * sha256加密方法
     * @param pwd 原始明文密码
     * @return 密文
     */
    public static String sha256(String pwd) {
        byte[] bbs = md.digest(pwd.getBytes());
        StringBuilder sb = new StringBuilder();
        //将比特数组转换成十六进制字符串
        for (byte bb : bbs) {
            int a = bb;
            if (0 > a) {
                a += 256;
            }
            if (16 > a) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(a));
        }
        return sb.toString();
    }

    /**
     * 生成随机盐 采用uuid
     * @return 随机盐
     */
    public static String generateSalt(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 校验密码
     * @param pwd  原始明文密码
     * @param salt 存储的随机盐
     * @param hash 存储的密码密文
     * @return 是否正确
     */
    public static boolean verify(String pwd,String salt,String hash){
        return hash.equals(sha256(pwd+salt));
    }
}
