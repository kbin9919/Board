package com.login.controller;
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
        LoginResponseDto response = service.login(request.id, request.pwd);
        return ResponseEntity.ok(response);
    }
}
