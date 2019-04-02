package com.dky.common.utils;

import com.dky.properties.JwtProperties;
import com.dky.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
*describe: JWT工具类
*
*@author bowen
*@date 2018/5/3
*/
public class JwtTokenUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String CLAIM_KEY_CREATED = "created";

    private static JwtProperties jwtProperties;

    public JwtTokenUtil(JwtProperties jwtPro){
        jwtProperties = jwtPro;
    }
    /**
     * token是否过期
     * @return  true：过期
     */
    public static boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public static String getSecret() {
        return jwtProperties.getSecret();
    }

    public static long getExpire() {
        return jwtProperties.getExpire();
    }

    public static String getHeader() {
        return jwtProperties.getHeader();
    }

    public static String getCoreId(){
        return jwtProperties.getCoreid();
    }

    public static String getKey(){
        return jwtProperties.getKey();
    }

    /**
    *describe: 获取token用户
    *@author bowen
    *@date 2018/5/10
    */
    public static String getUsernameByToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
    *describe: 获取token创建日期
    *@author bowen
    *@date 2018/5/10
    */
    public static Date getCreatedDateByToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    /**
    *describe: 获取超时日期
    *@author bowen
    *@date 2018/5/10
    */
    public static Date getExpireDateByToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    /**
    *describe:获取JWTClaims
    *@author bowen
    *@date 2018/5/10
    */
    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token.replace(jwtProperties.getCoreid(), ""))
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
    *describe: 获取失效时间
    *@author bowen
    *@date 2018/5/10
    */
    private static Date generateExpireDate() {
        return new Date(System.currentTimeMillis() + jwtProperties.getExpire() * 1000);
    }

    /**
     *describe: 获取用户token
     *@author bowen
     *@date 2018/5/10
     */
    public static String generateToken(String name){
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(CLAIM_KEY_CREATED, new Date());
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpireDate())
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .setSubject(name)
                .compact();
        return jwtProperties.getCoreid() + token;
    }

    /**
    *describe: token是否失效
    *@author bowen
    *@date 2018/5/10
    */
    public static Boolean isTokenExpired(String token) {
        final Date expiration = getExpireDateByToken(token);
        boolean isTrue = expiration.before(new Date());
        return isTrue;
    }

    /**
    *describe: 创建时间是否在指定时间之前
    *@author bowen
    *@date 2018/5/10
    */
    private static Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public static Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateByToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }

    /**
    *describe: 更新token
    *@author bowen
    *@date 2018/5/10
    */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims.getSubject());
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
    *describe: 控制层获取当前登录用户
    *@author bowen
    *@date 2018/5/11 9:15
    */
    public static String getUsername(HttpServletRequest request){
        return (String) request.getAttribute(jwtProperties.getKey());
    }
}
