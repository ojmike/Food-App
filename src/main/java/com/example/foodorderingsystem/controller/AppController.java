package com.example.foodorderingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AppController {




    @GetMapping("/")
    public ModelAndView showHomePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView showErrorPage(){
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}
