package com.login.repository;

import com.login.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByUserId(String Id);
}
