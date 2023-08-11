package com.milistock.milistock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milistock.milistock.entity.LikyEntity;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, String> {
    
}
