package com.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "User")
public class UserEntity {
    public String no;
    public String name;
    public String userId;
    public String userPwd;
    public String createdAt;
    public String deletedAt;
    public String delYn;
}
