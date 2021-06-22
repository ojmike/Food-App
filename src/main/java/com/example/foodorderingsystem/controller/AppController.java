package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.model.Cart;
import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.model.User;
import com.example.foodorderingsystem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    FoodService foodService;


    @GetMapping("/")
    public ModelAndView showHomePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

//    @GetMapping("/error")
//    public ModelAndView showErrorPage(){
//        ModelAndView modelAndView = new ModelAndView("error");
//        return modelAndView;
//    }
    @PostMapping("/addToCart")
    public @ResponseBody String addTOCard(HttpServletRequest req, HttpSession session,HttpSession httpSession){

        User user = (User) httpSession.getAttribute("user");
        System.out.println(user);
        System.out.println(req.getParameter("id"));


        Long foodId = Long.parseLong(req.getParameter("id"));
        Long quantity = Long.parseLong(req.getParameter("quantity"));
        double price = foodService.findById(foodId).get().getPrice();
        double totalPrice = quantity * price;


        if(foodService.addFoodToCart(user, foodId, quantity, totalPrice)){
            return "success";
        }else{
            return "failed";
        }




    }
    @GetMapping("/vieworder")
    public ModelAndView viewOrder(){
        ModelAndView modelAndView = new ModelAndView("vieworder");
        List<Cart> listOfCart = foodService.listAllCart();


        modelAndView.addObject("listOfCart", listOfCart);

        System.out.println(listOfCart);
        return  modelAndView;
    }


}
