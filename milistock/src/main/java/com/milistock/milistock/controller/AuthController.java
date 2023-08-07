package com.milistock.milistock.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milistock.milistock.dto.ResponseDto;
import com.milistock.milistock.dto.SignUpResponseDto;
import com.milistock.milistock.dto.SignUpDto;

@CrossOrigin(originPatterns="https://3000-taeyon998-milistockfron-b467ped2e3a.ws-us102.gitpod.io/")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @GetMapping("")
    public String hello(){
        return "Connection Successful";
    }
    @PostMapping("/signUp")
    public ResponseDto<SignUpResponseDto> signUp(@RequestBody SignUpDto requestBody) {
        System.out.println(requestBody.toString());
        return null;
    }
}
