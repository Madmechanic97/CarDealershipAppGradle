package com.sky.carDealershipApplication.Controller;

import com.sky.carDealershipApplication.Models.Booking;
import com.sky.carDealershipApplication.Models.Car;
import com.sky.carDealershipApplication.Models.User;
import com.sky.carDealershipApplication.Service.BookingService;
import com.sky.carDealershipApplication.Service.CarService;
import com.sky.carDealershipApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class BookingController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @ResponseBody
    @PostMapping("/booking/create")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking){
        Car carFromDb = carService.retrieveOne(booking.getCar().getCarId()).get();
        User userFromDb = userService.retrieveOne(booking.getUser().getUserId()).get();
        Optional<Booking> bookingRequired = bookingService.create(userFromDb, carFromDb);

        if(bookingRequired.get().getBookingId() != 0) {
            return new ResponseEntity<>("A booking has been confirmed with id :" + bookingRequired.get().getBookingId() + "." , HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Unsuccessful in creating a booking", HttpStatus.OK);
        }
    }

    @ResponseBody
    @PostMapping("cancelBooking/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable int bookingId){
        Optional<Booking> bookingFromDb = bookingService.retrieveOne(bookingId);
        if(bookingFromDb.isPresent()){
            bookingService.cancel(bookingFromDb.get());
            return new ResponseEntity<>("The booking has been canceled", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Booking with this booking not found", HttpStatus.NOT_FOUND);
        }

    }


}
