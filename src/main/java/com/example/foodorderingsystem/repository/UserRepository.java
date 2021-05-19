package com.example.foodorderingsystem.repository;

import com.example.foodorderingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
