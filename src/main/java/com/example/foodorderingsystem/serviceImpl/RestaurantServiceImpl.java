package com.example.foodorderingsystem.serviceImpl;

import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.repository.RestaurantRepository;
import com.example.foodorderingsystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Override
    public boolean registerNewRestaurant(Restaurant restaurant) {
        boolean flag = false;

        try {

            Restaurant restaurantData =restaurantRepository.findByEmail(restaurant.getEmail());


            if(restaurantData == null){
                System.out.println(restaurant);
                restaurantRepository.save(restaurant);
                flag = true;
            } else flag = false;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  flag;

    }






}
