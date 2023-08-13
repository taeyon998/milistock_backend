package com.milistock.milistock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    @NotBlank(message = "userEmail cannot be blank")
    private String userEmail;
    @NotBlank(message = "userPassword cannot be blank")
    private String userPassword;
}
