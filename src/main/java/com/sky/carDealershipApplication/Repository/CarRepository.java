package com.sky.carDealershipApplication.Repository;

import com.sky.carDealershipApplication.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByBrand(String brand);
}
