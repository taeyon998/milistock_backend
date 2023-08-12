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

        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }
}
