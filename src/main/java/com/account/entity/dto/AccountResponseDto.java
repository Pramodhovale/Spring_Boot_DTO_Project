package com.account.entity.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class AccountResponseDto {
    private String accountName;
    private Integer accountNumber;
    private String accountEmail;
    private Long accountBalance;

    public AccountResponseDto(Integer accountId, String accountName, String accountEmail, Long accountBalance) {
    }

    public AccountResponseDto() {

    }
}
