package com.sky.carDealershipApplication;


import com.sky.carDealershipApplication.Models.User;
import com.sky.carDealershipApplication.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserTests {
    private User user;


    @Autowired
    private UserService userService;

    @BeforeEach
    public void setup(){
        user = new User("Abdullah", "Tariq", "atariq@hotmail.com", new ArrayList<>());

    }

    @Test
    public void test_ThatAUserCanBePersisted(){
        userService.create(user);

        assertTrue(user.getUserId() != 0);
    }

    @Test
    public void test_ThatAUserCanRetrievedById(){
        userService.create(user);

        User userFromDb = userService.retrieveOne(user.getUserId()).get();

        assertTrue(user.getUserId() == 1);
    }

}
