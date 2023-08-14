package com.milistock.milistock.security;

import java.util.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenProvider {
    // JWT 생성 및 검증을 위한 키
    private static final String SECURITY_KEY = "jwtseckey!@";

    // JWT 생성하는 메서드
    public String create (String userEmail) {
        // 만료날짜 -> 현재 날짜 + 1시간 설정
        Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        // JWT를 생성
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
            .setSubject(userEmail).setIssuedAt(new Date()).setExpiration(exprTime)
            // 생성
            .compact();
    }

    // JWT 검증
    public String validate (String token) {
        // token을 디코딩
        Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
        // payload에서 제목 가져옴
        return claims.getSubject();
    }
}
