package util;


/**
 * @author MelloChan
 * @date 2018/5/22
 */
public class VerifyCodeGenerator {
    private VerifyCodeGenerator() {
    }

    public static String getFourVerifyCode() {
        int code = (int) (Math.random() * 9000 + 1000);
        return String.valueOf(code);
    }

    public static String getSixVerifyCode() {
        int code = (int) (Math.random() * 900000 + 100000);
        return String.valueOf(code);
    }

}
