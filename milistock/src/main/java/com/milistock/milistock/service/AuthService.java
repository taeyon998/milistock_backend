package com.milistock.milistock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milistock.milistock.dto.ResponseDto;
import com.milistock.milistock.dto.SignInDto;
import com.milistock.milistock.dto.SignUpDto;
import com.milistock.milistock.dto.SigninResponseDto;
import com.milistock.milistock.entity.UserEntity;
import com.milistock.milistock.repository.UserRepository;
import com.milistock.milistock.security.TokenProvider;

@Service
public class AuthService {

    @Autowired UserRepository userRepository;

    @Autowired TokenProvider tokenProvider;

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userpassword = dto.getUserPassword();
        String userpasswordCheck = dto.getUserPasswordCheck();

        // email 중복 확인
        userRepository.existsById(userEmail);
        
        // password check
        if (!userpassword.equals(userpasswordCheck))
            return ResponseDto.setFailed("Pswd does not match!");

        // dto를 통해 프론트에서 받아온 데이터로 user ENTITY 만듬
        UserEntity userEntity = new UserEntity(dto);

        // Repo를 통해 DB에 저장
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            return ResponseDto.setFailed("Data Base Error!");
        }

        return ResponseDto.setSuccess("Sign Up Success!", null);
    }

    public ResponseDto<SigninResponseDto> signIn(SignInDto dto){
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();

        // 회원가입 했는지 확인 (JWT랑 상관 x)
        try {
            boolean existed = userRepository.existsByuserEmailAndUserPassword(userEmail, userPassword);
            if (!existed) return ResponseDto.setFailed("Signin info does not match");
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }
        
        // userEntity 만듬
        UserEntity userEntity = null;
        try {
            userEntity = userRepository.findById(userEmail).get();
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }
        
        userEntity.setUserPassword("");

        // 핵심! Token을 만듬 (JWT)
        String token = tokenProvider.create(userEmail);
        int exprTime = 3600000;

        SigninResponseDto signInResponseDto = new SigninResponseDto(token, exprTime, userEntity);
        return ResponseDto.setSuccess("Sign In Success", signInResponseDto);
    }
}
