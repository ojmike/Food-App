package com.example.foodorderingsystem.controller;

//import com.example.foodorderingsystem.service.RestaurantService;
import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/restaurant_process")
    public ModelAndView showRestaurantLoginPage(){
        Restaurant restaurant = new Restaurant();
        ModelAndView modelAndView = new ModelAndView("restaurant_process");
        modelAndView.addObject("restaurant", restaurant);
        return modelAndView;
    }




    @PostMapping("process_restaurant_registration")
    public  ModelAndView processRestaurantsRegistration(@ModelAttribute("restaurant") Restaurant restaurant){
        if(restaurantService.registerNewRestaurant(restaurant) == true){
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("restaurant_process");
            return modelAndView;
        }
    }
}
