package com.sky.carDealershipApplication.Repository;

import com.sky.carDealershipApplication.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;


public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByBrand(String brand);
    //List<Car> findAllByOrderByYearDesc();
    List<Car> findByOrderByYearAsc();
    List<Car> findByOrderByYearDesc();
    List<Car> findByOrderByPriceAsc();
    List<Car> findByOrderByPriceDesc();
    List<Car> findByOrderByMileageAsc();
    List<Car> findByOrderByMileageDesc();
    List<Car> findByOrderByBrandAsc();
    List<Car> findByOrderByBrandDesc();

//    List<Car> findAllByOrderByBrand();
//    List<Car> findAllByOrderedByMileageAsc();
//    List<Car> findALlByOrderedByPriceAsc();



}
