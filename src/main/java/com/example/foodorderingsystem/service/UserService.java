package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.model.User;
import java.util.List;
public interface UserService {
    boolean saveNewUser(User user);
    List<User> listAllUser();
    User get(long id);
    boolean editUser(User user);
    User getUser(String email, String password);
}

