package com.example.springDataG124.service.impl;

import com.example.springDataG124.model.City;
import com.example.springDataG124.repository.CityRepository;
import com.example.springDataG124.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getCities() {
        return cityRepository.findAll();
    }
}
