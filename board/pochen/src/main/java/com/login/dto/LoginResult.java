package com.login.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResult {
    public String id;
    public String pwd;
    public String name;
    public String createdAt;
    public String deletedAt;
}
