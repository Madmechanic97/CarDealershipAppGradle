package com.sky.carDealershipApplication.Service;

import com.sky.carDealershipApplication.Models.Booking;
import com.sky.carDealershipApplication.Models.Car;
import com.sky.carDealershipApplication.Models.User;
import com.sky.carDealershipApplication.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Optional<Booking> create(User user, Car car){
        if(!car.getAvailability()){
            return Optional.of(new Booking(user, car));
        } else {
            car.setAvailability(false);
            return Optional.of(bookingRepository.save(new Booking(user, car)));
        }
    }

    public Optional<Booking> retrieveOne(int bookingId) {
        return bookingRepository.findById(bookingId);
    }

    public void cancel(Booking booking) {
        booking.getCar().setAvailability(true);
        bookingRepository.deleteById(booking.getBookingId());
    }

}
