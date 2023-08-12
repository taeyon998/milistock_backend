package com.milistock.milistock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milistock.milistock.dto.ResponseDto;
import com.milistock.milistock.dto.SignUpDto;
import com.milistock.milistock.service.AuthService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired AuthService authService;

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        System.out.println(requestBody.toString()); // optional, delete later

        // Service에서 백엔드 로직 (예: 중복id 확인) 후 repo를 통해 DB로 보냄
        ResponseDto<?> result = authService.signUp(requestBody);

        // Controller는 다시 프론트로 보냄
        return result;
    }
}
