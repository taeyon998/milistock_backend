package com.milistock.milistock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milistock.milistock.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    public boolean existsByuserEmailAndUserPassword(String userEmail, String userPassword);
}
