package com.example.foodorderingsystem.repository;

import com.example.foodorderingsystem.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findById(Long id);
}
