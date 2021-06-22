package com.example.foodorderingsystem.controller;

//import com.example.foodorderingsystem.service.RestaurantService;
import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.model.User;
import com.example.foodorderingsystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/restaurant_process")
    public ModelAndView showRestaurantLoginPage() {
        Restaurant restaurant = new Restaurant();
        ModelAndView modelAndView = new ModelAndView("restaurant_process");
        modelAndView.addObject("restaurant", restaurant);
        return modelAndView;
    }


    @PostMapping("process_restaurant_registration")
    public ModelAndView processRestaurantsRegistration(@ModelAttribute("restaurant") Restaurant restaurant) {
        if (restaurantService.registerNewRestaurant(restaurant) == true) {
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("restaurant_process");
            return modelAndView;
        }
    }


    @RequestMapping("/restaurant_list")
    public ModelAndView listOfRestaurants(Model model) {
        ModelAndView modelAndView = new ModelAndView("restaurant_list");
        List<Restaurant> listOfRestaurant = restaurantService.listAllRestaurant();
        modelAndView.addObject("listOfRestaurant", listOfRestaurant);
        return modelAndView;
    }

    @RequestMapping("/restaurant_listforcustomer")
    public ModelAndView listOfRestaurantsforCustomer(Model model) {
        ModelAndView modelAndView = new ModelAndView("restaurant_list_for_customer");
        List<Restaurant> listOfRestaurant = restaurantService.listAllRestaurant();
        modelAndView.addObject("listOfRestaurant", listOfRestaurant);
        return modelAndView;
    }


    @GetMapping("/edit_restaurant/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_restaurant");
        Restaurant restaurant = restaurantService.get(id);
        mav.addObject("restaurant", restaurant);

        return mav;
    }

    @RequestMapping(value = "/restaurant_dashboard", method = RequestMethod.GET)
    public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("restaurantdashboard");

        HttpSession httpSession = request.getSession();
        Restaurant restaurant = (Restaurant) httpSession.getAttribute("user");
        mav.addObject("restaurant", restaurant);
        return mav;
    }


    @PostMapping("/edit_restaurant")
    public ModelAndView editRestaurantDetails(@ModelAttribute("restarant") Restaurant restaurant) {
        if (restaurantService.editRestaurant(restaurant) == true) {
            ModelAndView modelAndView = new ModelAndView("redirect:/restaurant_list");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/customer_process");
            return modelAndView;
        }

    }





    @RequestMapping(value = "/restaurantloginProcess", method = RequestMethod.POST)
    public String loginProcess(HttpServletRequest request, HttpServletResponse response,
                               @ModelAttribute("restaurant") Restaurant restaurant) {
        Restaurant newRestaurant = restaurantService.getRestaurant(restaurant.getEmail(), restaurant.getPassword());

        HttpSession httpSession = request.getSession();

        if (null != newRestaurant) {
            httpSession.setAttribute("newRestaurant", newRestaurant);
            return "restaurantdashboard";
        } else {
            httpSession.setAttribute("message", "Email or Password is wrong!!!");
            return "redirect:/error";
        }

    }
}
