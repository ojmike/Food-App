package com.example.foodorderingsystem.serviceImpl;

import com.example.foodorderingsystem.model.Cart;
import com.example.foodorderingsystem.model.Food;
import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.model.User;
import com.example.foodorderingsystem.repository.CartRepository;
import com.example.foodorderingsystem.repository.FoodRepository;
import com.example.foodorderingsystem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    CartRepository cartRepository;
    @Override
    public boolean saveNewFood(Food food) {
                foodRepository.save(food);
                return  true;
    }

    @Override
    public List<Food> listAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> findById(Long id) {
        return foodRepository.findById(id);
    }

    public boolean addFoodToCart(User user, Long foodId, Long quantity, double totalPrice){

        boolean success = false;

        try {
            Food food = foodRepository.findById(foodId).get();
            Cart cart = new Cart();

            cart.setUser(user);
            cart.setFood(food);
            cart.setQuantity(quantity);
           cart.setTotalPrice(totalPrice);

            cartRepository.save(cart);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

    public List<Cart> listAllCart() {
        return cartRepository.findAll();
    }

}
