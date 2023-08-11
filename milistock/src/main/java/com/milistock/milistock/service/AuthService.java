package com.milistock.milistock.service;

import org.springframework.stereotype.Service;

import com.milistock.milistock.dto.ResponseDto;
import com.milistock.milistock.dto.SignUpDto;

@Service
public class AuthService {
    public ResponseDto<?> signUp(SignUpDto dto) {
        String userpassword = dto.getUserPassword();
        String userpasswordCheck = dto.getUserPasswordCheck();

        if (!userpassword.equals(userpasswordCheck))
            return ResponseDto.setFailed("Pswd does not match!")
    }
}
