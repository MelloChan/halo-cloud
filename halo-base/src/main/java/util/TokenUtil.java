package util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成与校验JWT机制生成的access_token
 *
 * @author MelloChan
 * @date 2018/5/1
 */
public class TokenUtil {
    private TokenUtil() {
    }

    private static final String SECRET = "halo-mobile-phone-qweasdoajfoangowqhbogonasdasdasdasdwqvzadas";

    /**
     * 创建jwt 过期时间60分钟
     *
     * @param uid 用户唯一id
     * @return jwt
     */
    public static String createToken(int uid) throws UnsupportedEncodingException {
        Date iatDate = new Date();
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.HOUR, 1);
        Date expireDate = nowTime.getTime();
        Map<String, Object> map = new HashMap<>(4);
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        try {
            return JWT.create()
                    .withHeader(map)
                    .withClaim("uid", uid)
                    .withIssuedAt(iatDate)
                    .withExpiresAt(expireDate)
                    .sign(Algorithm.HMAC256(SECRET));
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedEncodingException("Token创建失败");
        }
    }

    /**
     * 校验token是否有效,有效返回载荷json数据
     *
     * @param token access_token
     * @return claims
     */
    public static Map<String, Claim> verifyToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            return verifier.verify(token).getClaims();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * token是否临近过期 第55分钟是个临界值
     *
     * @param claims 载荷
     * @return 是否临近
     */
    public static boolean isCloseToExpire(Map<String, Claim> claims) {
        Long exp = claims.get("exp").asDate().getTime();
        Long now = System.currentTimeMillis();
        int diff = 300000;
        return exp - now <= diff;
    }
}
