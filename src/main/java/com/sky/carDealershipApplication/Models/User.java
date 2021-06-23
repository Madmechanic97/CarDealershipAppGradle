package com.sky.carDealershipApplication.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq")
    private int userId;

    private String firstName;
    private String lastName;
    private String email;

    @OneToMany
    private List<Booking> bookingList;

    public User(){
        super();
    }

    public User(String firstName, String lastName, String email, List<Booking> bookingList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bookingList = bookingList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && bookingList.equals(user.bookingList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, bookingList);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", bookingList=" + bookingList +
                '}';
    }

}
