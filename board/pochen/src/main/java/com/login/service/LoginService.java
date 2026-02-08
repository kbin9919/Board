package com.login.service;

import com.login.chain.LoginChainContext;
import com.login.chain.LoginChainResult;
import com.login.chain.LoginChainService;
import com.login.dto.response.LoginResponseDto;
import com.login.entity.UserEntity;
import com.login.repository.LoginRepostory;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginRepostory repository;
    public LoginChainService chainService;

    public LoginService(LoginRepostory repository, LoginChainService chainService)
    {
        this.repository = repository;
        this.chainService = chainService;
    }

    public LoginResponseDto login(String id, String pwd) {
        UserEntity userEntity = repository.getUser(id, pwd);

        LoginChainContext context = new LoginChainContext()
                .setInputId(id)
                .setInputPwd(pwd)
                .setId(userEntity.userId)
                .setPwd(userEntity.userId);

        LoginChainResult result = chainService.LoginVerification(context);

        return new LoginResponseDto();
    }
}
