package com.account.service;

import com.account.entity.Account;
import com.account.entity.dto.AccountRequestDto;
import com.account.entity.dto.AccountResponseDto;
import com.account.entity.projection.AccountProjection;
import com.account.mapper.CustomMapper;
import com.account.repositry.AccountRepository;
import com.account.service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper moduleMapper;

    @Override
    public String createAccount(AccountRequestDto accountRequestDto) {
        Account account = new Account();
        account.setAccountName(accountRequestDto.getAccountName());
        account.setAccountEmail(accountRequestDto.getAccountEmail());
        account.setAccountPassword(accountRequestDto.getAccountPassword());
        accountRepository.save(account);

        return "account deatils successfuly saved";
    }

    @Override
    public List<AccountResponseDto> getAllAccDetails() {
        List<Account> all = accountRepository.findAll();

        return all.stream()
                .map(account ->
                        moduleMapper.map(account, AccountResponseDto.class))
                .toList();
    }

    @Override
    public AccountResponseDto findAccountById(Integer accountId) {
        Optional<Account> account = accountRepository.findById(accountId);

        if(account.isPresent()) {
            Account account1 = account.get();

            AccountResponseDto accountResponseDto = new AccountResponseDto();

            accountResponseDto.setAccountEmail(account1.getAccountEmail());
            accountResponseDto.setAccountName(account1.getAccountName());
            accountResponseDto.setAccountBalance(account1.getAccountBalance());
            return accountResponseDto;

        }

        return null;
    }

    @Override
    public AccountResponseDto finaAccountusingCustomerMapper(Integer accountId) {
        Optional<Account> account = accountRepository.findById(accountId);

        if(account.isPresent()) {
            Account account1 = account.get();

            AccountResponseDto accountResponseDto = new AccountResponseDto();

            accountResponseDto.setAccountEmail(account1.getAccountEmail());
            accountResponseDto.setAccountName(account1.getAccountName());
            accountResponseDto.setAccountBalance(account1.getAccountBalance());
            return accountResponseDto;

        }

        return null;
    }

    @Override
    public AccountResponseDto getAccountByModleMapper(Integer accoutId) {
        Optional<Account> account = accountRepository.findById(accoutId);

        if(account.isPresent()) {
            Account account1 = account.get();
            AccountResponseDto acrd = moduleMapper.map(account1, AccountResponseDto.class);
            return acrd;
        }
        return null;
    }

    @Override
    public AccountProjection findAccountByIdWithProjection(Integer accountId) {
        return accountRepository.findAccountProjectedByAccountId(accountId);
    }

}
