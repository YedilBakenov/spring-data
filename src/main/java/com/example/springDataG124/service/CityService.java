package com.example.springDataG124.service;

import com.example.springDataG124.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<City> getCities();
}
