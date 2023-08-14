package com.milistock.milistock.security;

import org.springframework.stereotype.Service;

@Service
public class TokenProvider {
    // JWT 생성 및 검증을 위한 키
    private static final String SECURITY_KEY = "jwtseckey!@";

    // JWT 생성하는 메서드
    public String create (String userEmail) {
        
    }
}
