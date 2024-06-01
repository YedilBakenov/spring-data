package com.example.springDataG124.controller;

import com.example.springDataG124.model.Item;
import com.example.springDataG124.service.impl.CityServiceImpl;
import com.example.springDataG124.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/")
    public String main(Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "main";
    }

    @GetMapping(value = "/addpage")
    public String getAddPage(){
        return "add-page";
    }

    @PostMapping(value = "/add-item")
    public String addItem(Item item){
        itemService.addItem(item);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String getAddPage(@PathVariable int id, Model model){
        model.addAttribute("item", itemService.getById(id));
        model.addAttribute("cities", cityService.getCities());
        return "details-page";
    }

    @PostMapping(value = "/update-item")
    public String updateItem(Item item){
        itemService.updateItem(item);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-item")
    public String deleteItem(@RequestParam int id){
        itemService.deleteItem(id);
        return "redirect:/";
    }

    @GetMapping(value = "/details-name/{name}")
    public String getItemByName(@PathVariable String name, Model model){
       model.addAttribute("item", itemService.findByItemName(name));
        model.addAttribute("cities", cityService.getCities());
        return "details-page";
    }

    @GetMapping(value = "/item-search")
    public  String findByName(@RequestParam String search, Model model){
        model.addAttribute("items", itemService.getAllItemsByFilter(search));
        return "main";
    }
}
