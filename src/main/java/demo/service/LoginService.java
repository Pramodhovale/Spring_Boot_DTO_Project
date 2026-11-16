package demo.service;

import demo.entity.Login;
import demo.entity.dto.LoginRequestDto;
import demo.entity.dto.LoginResponseDto;
import demo.repository.LoginRepository;
import demo.service.impl.LoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginServiceImpl {

    private final LoginRepository loginRepository;

    @Override
    public LoginRequestDto createAndSave(LoginRequestDto loginRequestDto) {
        Login login = new Login();

        login.setLoginEmail(loginRequestDto.getLoginEmail());
        login.setLoginPassword(loginRequestDto.getLoginPassword());

        loginRepository.save(login);
        return loginRequestDto;
    }

    @Override
    public LoginResponseDto getDetailsById(Integer loginId) {
        Optional<Login> byId = loginRepository.findById(loginId);
        if(byId.isPresent()){
            Login login = byId.get();

            LoginResponseDto responseDto = new LoginResponseDto();

            responseDto.setLoginId(login.getLoginId());
            responseDto.setLoginEmail(login.getLoginEmail());
            responseDto.setLoginname(login.getLoginname());

            return responseDto;
        }
        return null;
    }

    @Override
    public LoginResponseDto fetchDetaisById(LoginRequestDto loginRequestDto) {
        Optional<Login> optional =
                loginRepository.findByLoginEmail(loginRequestDto.getLoginEmail());

        if (optional.isPresent()) {
            Login login = optional.get();
            if (login.getLoginPassword().equals(loginRequestDto.getLoginPassword())) {
                LoginResponseDto response = new LoginResponseDto();

                response.setLoginId(login.getLoginId());
                response.setLoginname(login.getLoginname());
                response.setLoginEmail(login.getLoginEmail());
                response.setMessage("Login successful");

                return response;
            }
        }

        throw new RuntimeException("Invalid email or password");

    }
}
