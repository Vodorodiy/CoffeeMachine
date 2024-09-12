package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.configuration.IngredienceAmountProperties;
import org.example.dto.CoffeeDto;
import org.example.dto.MakeCoffeeResponseDto;
import org.example.dto.SaveNewCoffeeDto;
import org.example.dto.TopCoffeeResponseDto;
import org.example.moduls.entity.Coffee;
import org.example.moduls.entity.Ingredient;
import org.example.moduls.entity.StorageItem;
import org.example.moduls.enums.ResponseStatus;
import org.example.repositories.CoffeeRepository;
import org.example.repositories.IngredientRepository;
import org.example.repositories.StorageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    private final IngredientRepository ingredientRepository;

    private final StorageRepository storageRepository;

    private final IngredienceAmountProperties ingredienceAmountProperties;

    public MakeCoffeeResponseDto makeCoffee(CoffeeDto coffeeDto) {
        Coffee coffee = coffeeRepository.findByCoffeeName(coffeeDto.getCoffeeName());
        if (coffee == null) {
            return new MakeCoffeeResponseDto(ResponseStatus.ERROR.getStatus(), "Coffee name not found");
        }
        for (Ingredient ingredient : coffee.getIngredients()) {
            StorageItem storageItem = storageRepository.findByIngredientName(ingredient.getIngredientName());
            Integer ingredientAmount = 0;
            String ingredientName = ingredient.getIngredientName();
            if(ingredienceAmountProperties.getRecipe().get(coffee.getCoffeeName()) == null) {
                ingredientAmount = 50;
            } else {
                ingredientAmount = ingredienceAmountProperties.getRecipe().get(coffee.getCoffeeName()).get(ingredientName);
                }
            if(storageItem.getUnitCount() < ingredientAmount) {
                    return new MakeCoffeeResponseDto(ResponseStatus.ERROR.getStatus(), "Not enough " + ingredientName);
                }
            }
        int newClickCount = coffee.getClickCount() + 1;
        coffee.setClickCount(newClickCount);
        coffeeRepository.save(coffee);
        return new MakeCoffeeResponseDto(ResponseStatus.OK.getStatus(), "You made " + coffee.getCoffeeName());
    }
    public void saveCoffee(SaveNewCoffeeDto saveNewCoffeeDto) {
        List<Ingredient> ingredientListForNewCoffee = new ArrayList<>();
        for (String inputIngredientName : saveNewCoffeeDto.getIngredientList()) {
            Ingredient ingredient = ingredientRepository.findByIngredientName(inputIngredientName);
            if (ingredient != null) {
                ingredientListForNewCoffee.add(ingredient);
            }
        }
        Coffee coffee = Coffee.builder()
                .coffeeName(saveNewCoffeeDto.getCoffeeName())
                .recipe(saveNewCoffeeDto.getRecipe())
                .ingredients(ingredientListForNewCoffee)
                .build();
        coffeeRepository.save(coffee);
        for (Ingredient ingredient : ingredientListForNewCoffee) {
            List<Coffee> currentCoffees = ingredient.getCoffeeList();
            currentCoffees.add(coffee);
            ingredient.setCoffeeList(currentCoffees);
            ingredientRepository.save(ingredient);
        }
    }
    public TopCoffeeResponseDto topCoffee() {
        List<Coffee> coffeeList = coffeeRepository.findAll();
        coffeeList.sort(Comparator.comparing(Coffee::getClickCount).reversed());
        List<String> topCoffeeList = coffeeList.stream()
                .map(coffee -> coffee.getCoffeeName())
                .limit(5)
                .collect(Collectors.toList());
        return new TopCoffeeResponseDto(topCoffeeList);
    }

}
