package com.example.springDataG124.service.impl;

import com.example.springDataG124.model.Item;
import com.example.springDataG124.repository.ItemRepository;
import com.example.springDataG124.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemServiceImpl  implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ArrayList<Item> getAllItems() {
        return (ArrayList<Item>)itemRepository.findAll();
    }

    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }


    @Override
    public Item getById(int id) {
        return itemRepository.findById(id).orElse(null);
    }
}
