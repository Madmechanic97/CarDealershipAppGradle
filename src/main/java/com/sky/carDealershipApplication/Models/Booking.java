package com.sky.carDealershipApplication.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_gen")
    @SequenceGenerator(name = "booking_gen", sequenceName = "booking_seq")
    private int bookingId;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDateTime timeStamp;

    @OneToOne
    private Car car;

    @ManyToOne
    private User user;

    public Booking(){
        super();
    }

    public Booking(User user, Car car) {
        this.car = car;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

//    public LocalDateTime getTimeStamp() {
//        return timeStamp;
//    }
//
//    public void setTimeStamp(LocalDateTime timeStamp) {
//        this.timeStamp = timeStamp;
//    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Booking booking = (Booking) o;
//        return bookingId == booking.bookingId && timeStamp.equals(booking.timeStamp) && car.equals(booking.car);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(bookingId, timeStamp, car);
//    }


//    @Override
//    public String toString() {
//        return "Booking{" +
//                "bookingId=" + bookingId +
//                ", timeStamp=" + timeStamp +
//                ", car=" + car +
//                '}';
//    }
}
