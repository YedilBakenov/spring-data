package com.example.springDataG124.service;

import com.example.springDataG124.model.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {

    List<Store> getAllStores();

    Store getStoreById(int id);

}
