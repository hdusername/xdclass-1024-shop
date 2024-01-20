package net.xdclass.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.model.LoginUser;

import java.util.Date;

public class JWTUtil {

    /**
     * token过期时间，7天
     */
    public static final long EXPIRE=1000*60*60*24*7;

    /**
     * 加密的密钥
     */
    public static final String SECRET = "lmlm";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX="lmlm";

    /**
     * SUBJECT
     */
    public static final String SUBJECT="lmlm";



    /**
     * 根据⽤户信息，⽣成令牌
     *
     * @param user
     * @return
     */
    public static String geneJsonWebToken(LoginUser user) {
        Long userId = user.getId();
        String token = Jwts.builder().setSubject(SUBJECT)
                        .claim("head_img", user.getHeadImg())
                        .claim("id", userId)
                        .claim("name", user.getName())
                        .claim("mail", user.getMail())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                        .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * 校验token的⽅法
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }
}
