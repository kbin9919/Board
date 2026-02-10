package com.login.chain;

@FunctionalInterface
public interface LoginChain {
    void validate(LoginChainContext context);
}
