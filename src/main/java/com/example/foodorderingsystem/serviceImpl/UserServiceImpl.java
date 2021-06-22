package com.example.foodorderingsystem.serviceImpl;

import com.example.foodorderingsystem.model.User;
import com.example.foodorderingsystem.repository.UserRepository;
import com.example.foodorderingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean saveNewUser(User user) {
        boolean flag = false;

        try {

            User userData =userRepository.findByEmail(user.getEmail());


            if(userData == null){
                System.out.println(user);
                userRepository.save(user);
                flag = true;
            } else flag = false;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  flag;
    }

    public boolean editUser(User user) {
        boolean flag = false;

        try {
                userRepository.save(user);
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  flag;
    }

    @Override
    public List<User> listAllUser() {
       return userRepository.findAll();
    }
    public User get(long id) {
        return userRepository.findById(id).get();
    }

    public User getUser(String email, String password){

        User userData = null;

        try {

            userData = userRepository.findByEmail(email);
            System.out.println(userData);

            if(!password.equals(userData.getPassword())){
                userData = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userData;
    }

}
