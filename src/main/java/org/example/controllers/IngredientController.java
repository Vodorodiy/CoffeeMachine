package org.example.controllers;

import org.example.dto.IngredientDto;
import org.example.dto.SaveNewCoffeeDto;
import org.example.moduls.entity.Ingredient;
import org.example.services.CoffeeService;
import org.example.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @PostMapping("/coffeeMachine/ingredient/add")
    public void addIngredient(@RequestBody IngredientDto ingredientDto) {
        ingredientService.addIngredientToStorage(ingredientDto);
    }
}
