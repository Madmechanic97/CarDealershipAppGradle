package com.sky.carDealershipApplication.Controller;

import com.sky.carDealershipApplication.Models.Car;
import com.sky.carDealershipApplication.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableAutoConfiguration
public class CarController {

    @Autowired
    private CarService carService;
    Comparator<Car> mileageComparator;

    @ResponseBody
    @GetMapping("/searchCarsByBrand")
    public ResponseEntity<?> retrieveCarsByBrand(@RequestParam String brand, @RequestParam String field, @RequestParam String ascending) {
        List<Car> carListWithName = carService.findCarsByBrand(brand);
        List<Car> carListToReturn;

        if (carListWithName.isEmpty()) {
            carListToReturn = carService.retrieveAllCars();
        } else {
            carListToReturn = carService.findCarsByBrand(brand);
        }
        Comparator<Car> yearComparator = (car1, car2) -> Integer.compare(car1.getYear(), car2.getYear());
        Comparator<Car> mileageComparator = (car1, car2) -> Integer.compare(car1.getMileage(), car2.getMileage());
        Comparator<Car> priceComparator = (car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice());
        Comparator<Car> nameComparator = (car1, car2) -> car1.getName().compareTo(car2.getName());

        if (field.equalsIgnoreCase("year") && ascending.equalsIgnoreCase("true")) {
            Collections.sort(carListToReturn, yearComparator);
            return new ResponseEntity<>(carListToReturn, HttpStatus.OK);
        } else if (field.equalsIgnoreCase("year") && ascending.equalsIgnoreCase("false")) {
            Collections.sort(carListToReturn, yearComparator);
            Collections.reverse(carListToReturn);
            return new ResponseEntity<>(carListToReturn, HttpStatus.OK);
        } else if (field.equalsIgnoreCase("mileage") && ascending.equalsIgnoreCase("true")) {
            Collections.sort(carListToReturn, mileageComparator);
            return new ResponseEntity<>(carListToReturn, HttpStatus.OK);
        } else if (field.equalsIgnoreCase("mileage") && ascending.equalsIgnoreCase("false")) {
            Collections.sort(carListToReturn, mileageComparator);
            Collections.reverse(carListToReturn);
            return new ResponseEntity<>(carListToReturn, HttpStatus.OK);
        } else if (field.equalsIgnoreCase("price") && ascending.equalsIgnoreCase("true")) {
            Collections.sort(carListToReturn, priceComparator);
            return new ResponseEntity<>(carListToReturn, HttpStatus.OK);
        } else if (field.equalsIgnoreCase("price") && ascending.equalsIgnoreCase("false")) {
            Collections.sort(carListToReturn, priceComparator);
            Collections.reverse(carListToReturn);
            return new ResponseEntity<>(carListToReturn, HttpStatus.OK);
        } else if (field.equalsIgnoreCase("name") && ascending.equalsIgnoreCase("true")) {
            Collections.sort(carListToReturn, nameComparator);
            return new ResponseEntity<>(carListToReturn, HttpStatus.OK);
        } else if (field.equalsIgnoreCase("name") && ascending.equalsIgnoreCase("false")) {
            Collections.sort(carListToReturn, nameComparator);
            Collections.reverse(carListToReturn);
            return new ResponseEntity<>(carListToReturn, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(carListToReturn, HttpStatus.OK);
        }

    }

}
