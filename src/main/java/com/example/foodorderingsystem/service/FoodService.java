package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.model.Cart;
import com.example.foodorderingsystem.model.Food;
import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.model.User;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    boolean saveNewFood(Food food);
    List<Food> listAllFood();
    Optional<Food> findById(Long id);
    boolean addFoodToCart(User user, Long foodId, Long quantity, double totalPrice);
    List<Cart> listAllCart();
}
