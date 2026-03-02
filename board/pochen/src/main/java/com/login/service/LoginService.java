package com.login.service;

import com.login.chain.LoginChainContext;
import com.login.chain.LoginChainFactory;
import com.login.chain.LoginChainService;
import com.login.dto.LoginResult;
import com.login.dto.request.LoginRequestDto;
import com.login.entity.UserEntity;
import com.login.repository.LoginRepository;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginRepository repository;
    public LoginChainService chainService;

    public LoginService(LoginRepository repository)
    {
        this.repository = repository;
        this.chainService = new LoginChainService(new LoginChainFactory());
    }

    public LoginResult login(LoginRequestDto request) {

        //Todo 에러코드 Constant 분리하기
        UserEntity userEntity = repository.findById(request.id)
                .orElseThrow(() -> new SqlScriptException(""));

        LoginChainContext context = LoginChainContext.builder()
                .inputId(request.id)
                .inputPwd(request.pwd)
                .realId(userEntity.userId)
                .realPwd(userEntity.userPwd)
                .build();

        chainService.LoginVerification(context);

        // Todo 간소화하기
        return LoginResult.builder()
                .id(userEntity.userId)
                .pwd(userEntity.userId)
                .name(userEntity.name)
                .build();
    }
}
