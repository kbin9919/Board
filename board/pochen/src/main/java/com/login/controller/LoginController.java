package com.login.controller;
import com.login.dto.LoginResult;
import com.login.dto.request.LoginRequestDto;
import com.login.dto.response.LoginResponseDto;
import com.login.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    public LoginService service;

    public LoginController(LoginService service)
    {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto request) {
        LoginResult result = service.login(request.id, request.pwd);

        //Todo 간소화하기
        LoginResponseDto response = new LoginResponseDto();
        response.id = result.id;
        response.pwd = result.pwd;
        response.name = result.name;

        return ResponseEntity.ok(response);
    }
}
