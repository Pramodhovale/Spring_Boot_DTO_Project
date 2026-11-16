package com.account.controller;

import com.account.entity.dto.AccountRequestDto;
import com.account.entity.dto.AccountResponseDto;
import com.account.entity.projection.AccountProjection;
import com.account.service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dto")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    public String createAccount(@RequestBody AccountRequestDto accountRequestDto) {
        return  accountService.createAccount(accountRequestDto);
    }

    @GetMapping("/getAllDetails")
    public List<AccountResponseDto> getAllDetails(){
        return accountService.getAllAccDetails();
    }

    @GetMapping("/get/{accountId}")
    public AccountResponseDto findAccountById(@PathVariable Integer accountId) {
        return  accountService.findAccountById(accountId);
    }

    @GetMapping("/map/{accountId}")
    public AccountResponseDto findAccountUsingCustomMapper(@PathVariable Integer accountId){
        return accountService.finaAccountusingCustomerMapper(accountId);
    }

    @GetMapping("/ModelMapper/{accoutId}")
    public AccountResponseDto getAccountByModleMapper(@PathVariable Integer accoutId) {
        return accountService.getAccountByModleMapper(accoutId);
    }

    @GetMapping("/AccountProjection/{accountId}")
    public AccountProjection findByIdwithProjection(@PathVariable Integer accountId) {
        return  accountService.findAccountByIdWithProjection(accountId);
    }

}
