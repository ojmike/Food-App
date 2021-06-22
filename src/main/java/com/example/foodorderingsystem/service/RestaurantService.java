package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.model.User;

import java.util.List;

public interface RestaurantService {
    boolean registerNewRestaurant(Restaurant restaurant);
    List<Restaurant> listAllRestaurant();
    Restaurant get(long id);
    boolean editRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(String email, String password);

}
