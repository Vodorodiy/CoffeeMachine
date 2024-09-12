package org.example.repositories;

import org.example.moduls.entity.Ingredient;
import org.example.moduls.entity.StorageItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<StorageItem, Long> {
    StorageItem findByIngredientName(String ingredientName);
}
