package com.sky.carDealershipApplication.Controller;

import com.sky.carDealershipApplication.Models.Car;
import com.sky.carDealershipApplication.Models.User;
import com.sky.carDealershipApplication.Service.CarService;
import com.sky.carDealershipApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @GetMapping("/Login")
    public ResponseEntity<?> userLogin(@RequestParam String email){
        User userFromDb = userService.checkUserEmail(email);
        if(userFromDb == null){
            return new ResponseEntity<>("Incorrect email, no such user exists", HttpStatus.NOT_FOUND);
        } else {
            List<Car> allCars = carService.retrieveAllCars();
            return new ResponseEntity<>(allCars, HttpStatus.OK);
        }

    }
}
