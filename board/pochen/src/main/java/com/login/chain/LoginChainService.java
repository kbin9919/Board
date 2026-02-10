package com.login.chain;

public class LoginChainService {
    public LoginChainFactory chainFactory;

    public LoginChainService(LoginChainFactory chainFactory){
        this.chainFactory = chainFactory;
    }

    public void LoginVerification(LoginChainContext context) {
        chainFactory.validators().forEach(v -> v.validate(context));
    }
}
