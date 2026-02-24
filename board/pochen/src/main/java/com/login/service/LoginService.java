package com.login.service;

import com.login.chain.LoginChainContext;
import com.login.chain.LoginChainService;
import com.login.dto.LoginResult;
import com.login.dto.request.LoginRequestDto;
import com.login.entity.UserEntity;
import com.login.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginRepository repository;
    public LoginChainService chainService;

    public LoginService(LoginRepository repository, LoginChainService chainService)
    {
        this.repository = repository;
        this.chainService = chainService;
    }

    public LoginResult login(LoginRequestDto request) {
        UserEntity userEntity = repository.getUser(request.id, request.pwd);

        LoginChainContext context = new LoginChainContext()
                .setInputId(request.id)
                .setInputPwd(request.pwd)
                .setId(userEntity.userId)
                .setPwd(userEntity.userId);

        chainService.LoginVerification(context);

        // Todo 간소화하기
        return LoginResult.builder()
                .id(userEntity.userId)
                .pwd(userEntity.userId)
                .name(userEntity.name)
                .build();
    }
}
