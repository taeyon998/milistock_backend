package com.milistock.milistock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milistock.milistock.entity.CommentEntity;
import com.milistock.milistock.entity.PopularSearchEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    
}
