package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.model.User;
import com.example.foodorderingsystem.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {
    @Autowired
    UserService userService;

    @GetMapping("/customer_process")
    public ModelAndView showCustomerLoginPage() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("customer_process");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/save_customer")
    public ModelAndView saveNewCustomerDetails(@ModelAttribute("user") User user) {
        if (userService.saveNewUser(user) == true) {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("customer_process");
            return modelAndView;
        }

    }

    @PostMapping("/edit_customer")
    public ModelAndView editCustomerDetails(@ModelAttribute("user") User user) {
        if (userService.editUser(user) == true) {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("customer_process");
            return modelAndView;
        }

    }


    @RequestMapping("/customer_list")
    public ModelAndView showCustomerList(Model model) {
        ModelAndView modelAndView = new ModelAndView("customer_list");
        List<User> listOfUser = userService.listAllUser();
        System.out.println(listOfUser);
        modelAndView.addObject("listOfUser", listOfUser);
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userService.get(id);
        mav.addObject("user", user);

        return mav;
    }


    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String loginProcess(HttpServletRequest request, HttpServletResponse response,
                               @ModelAttribute("login") User user) {

        User newUser = userService.getUser(user.getEmail(), user.getPassword());

        HttpSession httpSession = request.getSession();

        if (null != newUser) {
            httpSession.setAttribute("user", newUser);
            return "redirect:/customer_dashboard";
        } else {
            httpSession.setAttribute("message", "Email or Password is wrong!!!");
            return "redirect:/error";
        }


    }


    @RequestMapping(value = "/customer_dashboard", method = RequestMethod.GET)
    public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("customer_dashboard");

        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        mav.addObject("user", user);
        return mav;
    }
}
