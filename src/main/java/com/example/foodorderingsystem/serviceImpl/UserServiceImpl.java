package com.example.foodorderingsystem.serviceImpl;

import com.example.foodorderingsystem.model.User;
import com.example.foodorderingsystem.repository.UserRepository;
import com.example.foodorderingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
