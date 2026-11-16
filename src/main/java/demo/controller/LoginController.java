package demo.controller;

import demo.entity.dto.LoginRequestDto;
import demo.entity.dto.LoginResponseDto;
import demo.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginSevice;

    @PostMapping("/save")
    public LoginRequestDto createAndSave(@RequestBody LoginRequestDto loginRequestDto){
        return loginSevice.createAndSave(loginRequestDto);
    }

    @GetMapping("/getDeatilsById/{loginId}")
    public LoginResponseDto getDeatilsById(@PathVariable Integer loginId) {
        return loginSevice.getDetailsById(loginId);
    }

    @PostMapping("/fecthByDeails")
    public LoginResponseDto fecthByDeatils(@RequestBody LoginRequestDto loginRequestDto) {
      return  loginSevice.fetchDetaisById(loginRequestDto);
    }
}
