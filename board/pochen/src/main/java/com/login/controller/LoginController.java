package com.login.controller;
import com.login.dto.LoginResult;
import com.login.dto.request.LoginRequestDto;
import com.login.dto.response.LoginResponseDto;
import com.login.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    public LoginService service;

    public LoginController(LoginService service)
    {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto request)
    {
        System.out.println(request.id);
        System.out.println(request.pwd);
        
        LoginResult result = service.login(request);

        LoginResponseDto response = LoginResponseDto.builder()
                                    .id(result.id)
                                    .name(result.name)
                                    .build();

        return "loginSuccess";  // login.jsp
//        return ResponseEntity.ok(response);
    }
}
