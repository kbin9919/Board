package com.login.controller;
import com.login.dto.LoginResult;
import com.login.dto.request.LoginRequestDto;
import com.login.dto.response.LoginResponseDto;
import com.login.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    public LoginService service;

    public LoginController(LoginService service)
    {
        this.service = service;
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@AuthenticationPrincipal UserDetails userDetails)
    {
        LoginResult result = service.login(userDetails.getUsername(), userDetails.getPassword());

        LoginResponseDto response = LoginResponseDto.builder()
                .id(result.id)
                .pwd(result.pwd)
                .name(result.name)
                .build();

        return ResponseEntity.ok(response);
    }
}
