package com.login.entity;

import jakarta.persistence.Entity;

@Entity
public class UserEntity {
    public String no;
    public String name;
    public String userId;
    public String userPwd;
    public String createdAt;
    public String deletedAt;
    public String delYn;
}
