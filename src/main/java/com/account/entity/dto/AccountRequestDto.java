package com.account.entity.dto;

import lombok.Data;

@Data
public class AccountRequestDto {
    private String accountName;
    private String accountEmail;
    private String accountPassword;
    private Long   accountBalance;
}
