package com.guilherme.menu_app.controller;


import com.guilherme.menu_app.food.Food;
import com.guilherme.menu_app.food.FoodRepository;
import com.guilherme.menu_app.food.FoodRequestDTO;
import com.guilherme.menu_app.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodsList = repository.findAll().stream()
            .map(FoodResponseDTO::new)
            .toList();
        return foodsList;
    }

}
