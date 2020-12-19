package com.flyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flyway.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}


