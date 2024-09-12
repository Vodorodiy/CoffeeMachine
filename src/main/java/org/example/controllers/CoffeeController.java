package org.example.controllers;

import org.example.dto.CoffeeDto;
import org.example.dto.MakeCoffeeResponseDto;
import org.example.dto.SaveNewCoffeeDto;
import org.example.dto.TopCoffeeResponseDto;
import org.example.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {

    @Autowired
    CoffeeService coffeeService;

    @PostMapping("/coffeeMachine/coffee/make")
    public MakeCoffeeResponseDto makeCoffee(@RequestBody CoffeeDto coffeeDto) {
        return coffeeService.makeCoffee(coffeeDto);
    }

    @PostMapping("/coffeeMachine/coffee/save")
    public void saveCoffee(@RequestBody SaveNewCoffeeDto saveNewCoffeeDto) {
        coffeeService.saveCoffee(saveNewCoffeeDto);
    }

    @GetMapping("/coffeeMachine/coffee/top")
    public TopCoffeeResponseDto topCoffee() {
        return coffeeService.topCoffee();
    }
}
