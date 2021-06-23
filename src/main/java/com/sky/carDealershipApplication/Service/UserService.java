package com.sky.carDealershipApplication.Service;

import com.sky.carDealershipApplication.Models.User;
import com.sky.carDealershipApplication.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void create(User user) {
        userDao.save(user);
    }


    public Optional<User> retrieveOne(int userId) {

        return userDao.findById(userId);
    }
}
