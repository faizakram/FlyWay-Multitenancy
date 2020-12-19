package com.flyway.controller;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flyway.entity.Car;
import com.flyway.repository.CarRepository;

@RestController
@Transactional
@RequestMapping(path = "/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Car insert(@RequestBody Car car){
    	System.out.println(car.getColor());
        return carRepository.save(car);
    }

    @GetMapping
    public List<Car> posts(){
        return carRepository.findAll();
    }
}
