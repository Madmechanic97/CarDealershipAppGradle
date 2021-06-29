package com.sky.carDealershipApplication.Service;

import com.sky.carDealershipApplication.Models.User;
import com.sky.carDealershipApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }
    
    public Optional<User> retrieveOne(int userId) {
        return userRepository.findById(userId);
    }

    public User checkUserEmail(String email){
        return userRepository.findByEmail(email);
    }


}
