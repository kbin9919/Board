package com.login.chain;

import lombok.Data;

public class LoginChainContext {
    public String inputId;
    public String inputPwd;
    public String id;
    public String pwd;

    public LoginChainContext setInputId(String inputId) {
        this.inputId = inputId;
        return this;
    }

    public LoginChainContext setInputPwd(String inputPwd) {
        this.inputPwd = inputPwd;
        return this;
    }

    public LoginChainContext setId(String id) {
        this.id = id;
        return this;
    }
    public LoginChainContext setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

}
