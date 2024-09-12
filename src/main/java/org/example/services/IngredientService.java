package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dto.IngredientDto;
import org.example.moduls.entity.Ingredient;
import org.example.moduls.entity.StorageItem;
import org.example.repositories.IngredientRepository;
import org.example.repositories.StorageRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    private final StorageRepository storageRepository;

    public void addIngredientToStorage(IngredientDto ingredientDto) {

        StorageItem storageItem = storageRepository.findByIngredientName(ingredientDto.getIngredientName());
        Ingredient ingredient = ingredientRepository.findByIngredientName(ingredientDto.getIngredientName());
        if (ingredient == null) {
            ingredient = Ingredient.builder()
                    .ingredientName(ingredientDto.getIngredientName())
                    .build();
        }
        ingredientRepository.save(ingredient);
        if (storageItem == null) {
            StorageItem newStorageItem = StorageItem.builder()
                    .ingredientName(ingredientDto.getIngredientName())
                    .unitCount(ingredientDto.getCount())
                    .ingredient(ingredient)
                    .build();
            ingredient.setStorage(newStorageItem);
            ingredientRepository.save(ingredient);
            storageRepository.save(newStorageItem);
        } else {
            int currentCountInStorage = storageItem.getUnitCount();
            int finalCountInStorage = currentCountInStorage + ingredientDto.getCount();
            storageItem.setUnitCount(finalCountInStorage);
            storageRepository.save(storageItem);
        }
    }
}
