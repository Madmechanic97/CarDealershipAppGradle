package com.sky.carDealershipApplication.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_gen")
    @SequenceGenerator(name = "booking_gen", sequenceName = "booking_seq")
    private int bookingId;

    private Date timeBooked;

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
        this.timeBooked = new Date();
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getTimeBooked() {
        return timeBooked;
    }

    public void setTimeBooked(Date timeBooked) {
        this.timeBooked = timeBooked;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", timeBooked=" + timeBooked +
                ", car=" + car +
                ", user=" + user +
                '}';
    }
}
