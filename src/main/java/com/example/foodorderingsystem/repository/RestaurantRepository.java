package com.example.foodorderingsystem.repository;

import com.example.foodorderingsystem.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findByEmail(String email);
}
