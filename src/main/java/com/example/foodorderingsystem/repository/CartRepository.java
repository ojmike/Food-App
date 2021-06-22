package com.example.foodorderingsystem.repository;

import com.example.foodorderingsystem.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
