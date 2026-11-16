package com.account.mapper;

import com.account.entity.Account;
import com.account.entity.dto.AccountResponseDto;

public class CustomMapper {
    public  static AccountResponseDto MapAccountToAccountRespDto (Account account) {
        AccountResponseDto accountResponseDto = new AccountResponseDto();

        accountResponseDto.setAccountBalance(account.getAccountBalance());
        accountResponseDto.setAccountName(account.getAccountName());
        accountResponseDto.setAccountEmail(account.getAccountEmail());
        accountResponseDto.setAccountNumber(account.getAccountId());

        return accountResponseDto;
    }
}
