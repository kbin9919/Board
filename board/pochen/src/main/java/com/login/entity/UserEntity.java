package com.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Users")
public class UserEntity {
    public String no;
    public String name;
    @Id
    public String userId;
    public String userPwd;
    public String createdAt;
    public String deletedAt;
    public String delYn;
}
