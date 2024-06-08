package com.example.springDataG124.service.impl;

import com.example.springDataG124.model2.Car;
import com.example.springDataG124.repository2.CarRepository2;
import com.example.springDataG124.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository2 carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
