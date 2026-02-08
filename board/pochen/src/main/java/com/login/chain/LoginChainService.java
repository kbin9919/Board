package com.login.chain;

public class LoginChainService {
    public LoginChainFactory chainFactory;

    public LoginChainService(LoginChainFactory chainFactory){
        this.chainFactory = chainFactory;
    }

    public LoginChainResult LoginVerification(LoginChainContext context) {
        return null;
    }
}
