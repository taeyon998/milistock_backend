package com.milistock.milistock.dto;

// import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    // @NotBlank
    private String userEmail;
    private String userPassword;
}
