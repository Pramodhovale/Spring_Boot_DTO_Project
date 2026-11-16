package demo.entity.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String loginEmail;
    private String loginPassword;
}

