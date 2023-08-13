package com.milistock.milistock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milistock.milistock.dto.ResponseDto;
import com.milistock.milistock.dto.SignInDto;
import com.milistock.milistock.dto.SignUpDto;
import com.milistock.milistock.dto.SigninResponseDto;
import com.milistock.milistock.entity.UserEntity;
import com.milistock.milistock.repository.UserRepository;

@Service
public class AuthService {

    @Autowired UserRepository userRepository;

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
        boolean existed = userRepository.existsByEmailAndUserPassword(userEmail, userPassword);
    }
}
