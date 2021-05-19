package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.model.User;
import com.example.foodorderingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    UserService userService;

    @GetMapping("/customer_process")
    public ModelAndView showCustomerLoginPage(){
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("customer_process");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/save_customer")
    public ModelAndView saveNewCustomerDetails(@ModelAttribute("user") User user){
        if(userService.saveNewUser(user) == true){
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("customer_process");
            return modelAndView;
        }

    }


}
