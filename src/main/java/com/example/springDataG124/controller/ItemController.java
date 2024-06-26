package com.example.springDataG124.controller;

import com.example.springDataG124.model.Item;
import com.example.springDataG124.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private StoreServiceImpl storeService;

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "main";
    }

    @GetMapping(value = "/addpage")
    public String getAddPage() {
        return "add-page";
    }

    @PostMapping(value = "/add-item")
    public String addItem(Item item) {
        itemService.addItem(item);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String getAddPage(@PathVariable int id, Model model) {
        var stores = storeService.getAllStores();
        var item = itemService.getById(id);

        stores.removeAll(item.getStores());

        model.addAttribute("item", item);
        model.addAttribute("cities", cityService.getCities());
        model.addAttribute("stores", stores);
        return "details-page";
    }

    @PostMapping(value = "/add-store")
    public String addStore(@RequestParam int item_id,
                           @RequestParam int store_id,
                           Model model) {

        var item = itemService.getById(item_id);
        var store = storeService.getStoreById(store_id);

        item.getStores().add(store);
        itemService.updateItem(item);

        model.addAttribute("item", item);
        model.addAttribute("store", store);

        return "redirect:/details/"+ item_id;
    }

    @PostMapping(value = "/delete-store")
    public String deleteStore(@RequestParam int item_id,
                           @RequestParam int store_id,
                           Model model) {

        var item = itemService.getById(item_id);
        var store = storeService.getStoreById(store_id);

        item.getStores().remove(store);
        itemService.updateItem(item);

        model.addAttribute("item", item);
        model.addAttribute("store", store);

        return "redirect:/details/"+ item_id;
    }


    @PostMapping(value = "/update-item")
    public String updateItem(Item item) {
        itemService.updateItem(item);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-item")
    public String deleteItem(@RequestParam int id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }

    @GetMapping(value = "/details-name/{name}")
    public String getItemByName(@PathVariable String name, Model model) {
        model.addAttribute("item", itemService.findByItemName(name));
        model.addAttribute("cities", cityService.getCities());
        return "details-page";
    }

    @GetMapping(value = "/item-search")
    public String findByName(@RequestParam String search, Model model) {
        model.addAttribute("items", itemService.getAllItemsByFilter(search));
        return "main";
    }
}
