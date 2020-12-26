package com.ribpet.component;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class TokenService {
    /**
     * 生成Token
     *
     * @param sub
     * @return
     */
    public String createToken(String sub) {
        Calendar calendar = GregorianCalendar.getInstance();
        Date iat = calendar.getTime();
        calendar.add(GregorianCalendar.MINUTE, amount);
        Date exp = calendar.getTime();

        return Jwts.builder()//
                .setHeaderParam("typ", "JWT")// 令牌类型
                .setSubject(sub)// 主题
                .setIssuedAt(iat) // 签发时间
                .setExpiration(exp)// 过期时间
                .signWith(SignatureAlgorithm.HS512, secretKey)// 签名算法、秘钥
                .compact();
    }

    /**
     * 获取Token中注册信息
     *
     * @param token
     * @return
     */
    public Claims getBody(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    /**
     * 获取签发日期
     *
     * @param token
     * @return
     */
    public Date getIssuedAt(String token) {
        return getBody(token).getIssuedAt();
    }

    /**
     * 获取过期时间
     *
     * @param token
     * @return
     */
    public Date getExpiration(String token) {
        return getBody(token).getExpiration();
    }

    /**
     * 获取主题信息
     *
     * @param token
     * @return
     */
    public String getSubject(String token) {
        return getBody(token).getSubject();
    }

    // 令牌秘钥
    @Value("${token.secret}")
    private String secretKey;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int    amount;
}
