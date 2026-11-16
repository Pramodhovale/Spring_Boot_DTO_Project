package demo.entity.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private Integer loginId;
    private String  loginname;
    private String  loginEmail;
    private String  message;
}
