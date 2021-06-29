package com.sky.carDealershipApplication.Service;

import com.sky.carDealershipApplication.Models.Car;
import com.sky.carDealershipApplication.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<Car> retrieveAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public List<Car> sortByYearAsc() {
        return carRepository.findByOrderByYearAsc();
    }

    public List<Car> sortByYearDesc() {
        return carRepository.findByOrderByYearDesc();
    }

    public List<Car> sortByPriceAsc(){
        return carRepository.findByOrderByPriceAsc();
    }

    public List<Car> sortByPriceDesc(){
        return carRepository.findByOrderByPriceDesc();

    }

    public List<Car> sortByMileageAsc(){
        return carRepository.findByOrderByMileageAsc();
    }

    public List<Car> sortByMileageDesc(){
        return carRepository.findByOrderByMileageDesc();
    }

    public List<Car> sortByBrandAsc(){
        return carRepository.findByOrderByBrandAsc();
    }

    public List<Car> sortByBrandDesc(){
        return carRepository.findByOrderByBrandDesc();
    }

    public Optional<Car> retrieveOne(int carId) {
        return carRepository.findById(carId);
    }
}
