package demo.service.impl;

import demo.entity.Login;
import demo.entity.dto.LoginRequestDto;
import demo.entity.dto.LoginResponseDto;

public interface LoginServiceImpl {
    LoginRequestDto createAndSave(LoginRequestDto loginRequestDto);

    LoginResponseDto getDetailsById(Integer loginId);

    LoginResponseDto fetchDetaisById(LoginRequestDto loginRequestDto);
}
