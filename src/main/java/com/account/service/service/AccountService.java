package com.account.service.service;

import com.account.entity.dto.AccountRequestDto;
import com.account.entity.dto.AccountResponseDto;
import com.account.entity.projection.AccountProjection;

import java.util.List;

public interface AccountService {
    String createAccount(AccountRequestDto accountRequestDto);

    List<AccountResponseDto> getAllAccDetails();

    AccountResponseDto findAccountById(Integer accountId);

    AccountResponseDto finaAccountusingCustomerMapper(Integer accountId);

    AccountResponseDto getAccountByModleMapper(Integer accoutId);

    AccountProjection findAccountByIdWithProjection(Integer accountId);
}
