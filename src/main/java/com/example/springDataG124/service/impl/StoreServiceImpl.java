package com.example.springDataG124.service.impl;

import com.example.springDataG124.model.Store;
import com.example.springDataG124.repository.StoreRepository;
import com.example.springDataG124.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getStoreById(int id) {
        return storeRepository.findById(id).orElse(null);
    }
}
