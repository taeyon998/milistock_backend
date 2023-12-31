package com.milistock.milistock.dto;

import com.milistock.milistock.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigninResponseDto {
    private String token;
    private int exprTime;
    private UserEntity user;
}
