package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.model.Food;
import com.example.foodorderingsystem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FoodController {
    @Autowired
    FoodService foodService;


    @GetMapping("/addfood")
    public ModelAndView addNewFood(){
        Food food = new Food();
        ModelAndView modelAndView = new ModelAndView("enterfooddetails");
        modelAndView.addObject("food", food);
        return modelAndView;
    }

    @PostMapping("/save_food")
    public ModelAndView saveNewFood(@ModelAttribute("food") Food food){
        if(foodService.saveNewFood(food) == true){
            ModelAndView modelAndView = new ModelAndView("redirect:/restaurantdashboard");
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("customer_process");
            return modelAndView;
        }

    }


    @RequestMapping("/food_list")
    public ModelAndView listOfRestaurants(Model model){
        ModelAndView modelAndView = new ModelAndView("showlistoffood");
        List<Food> listOfFood = foodService.listAllFood();
        System.out.println(listOfFood);
        modelAndView.addObject("listOfFood",listOfFood);
        return modelAndView;
    }

}
