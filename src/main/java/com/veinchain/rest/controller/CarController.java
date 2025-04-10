package com.veinchain.rest.controller;

import com.veinchain.rest.entities.Car;
import com.veinchain.rest.repository.CarRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@RestController("/car")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public Car fetchCarByUuid(String id) {
        return carRepository.findById(UUID.fromString(id)).orElseGet(null);
    }

    @PostMapping
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public boolean delete(String id) {
        var car = carRepository.findById(UUID.fromString(id));
        carRepository.delete(car.get());
        return true;
    }
}
