package com.example.foodorderingsystem.serviceImpl;

import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.model.User;
import com.example.foodorderingsystem.repository.RestaurantRepository;
import com.example.foodorderingsystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Restaurant> listAllRestaurant() {
        return restaurantRepository.findAll();
    }

    public Restaurant get(long id) {
        return restaurantRepository.findById(id).get();
    }

    public boolean editRestaurant(Restaurant restaurant) {
        boolean flag = false;

        try {
            restaurantRepository.save(restaurant);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  flag;
    }


    public Restaurant getRestaurant(String email, String password){

        Restaurant restaurantData = null;

        try {

            restaurantData = restaurantRepository.findByEmail(email);


            if(!password.equals(restaurantData.getPassword())){
                restaurantData = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return restaurantData;
    }

}
