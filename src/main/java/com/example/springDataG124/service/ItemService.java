package com.example.springDataG124.service;

import com.example.springDataG124.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ItemService {

    ArrayList<Item> getAllItems();

    void addItem(Item item);

    void deleteItem(int id);

    void updateItem(Item item);

    Item getById(int id);

    Item findByItemName(String name);

    List<Item>getAllItemsByFilter(String search);
}
