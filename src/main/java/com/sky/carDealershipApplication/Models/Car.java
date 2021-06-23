package com.sky.carDealershipApplication.Models;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_gen")
    @SequenceGenerator(name = "car_gen", sequenceName = "car_seq")
    private int carId;

    private int year;
    private double price;
    private String name;
    private int mileage;

    public Car(){
        super();
    }

    public Car(int year, double price, String name, int mileage) {
        this.year = year;
        this.price = price;
        this.name = name;
        this.mileage = mileage;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", year=" + year +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}
