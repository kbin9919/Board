package com.login.chain;

import lombok.Data;

public class LoginChainContext {
    public String inputId;
    public String inputPwd;
    public String realId;
    public String realPwd;

    public LoginChainContext setInputId(String inputId) {
        this.inputId = inputId;
        return this;
    }

    public LoginChainContext setInputPwd(String inputPwd) {
        this.inputPwd = inputPwd;
        return this;
    }

    public LoginChainContext setId(String id) {
        this.realId = id;
        return this;
    }
    public LoginChainContext setPwd(String pwd) {
        this.realPwd = pwd;
        return this;
    }

}
