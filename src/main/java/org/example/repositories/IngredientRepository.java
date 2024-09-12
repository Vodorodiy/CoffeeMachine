package org.example.repositories;

import org.example.moduls.entity.Coffee;
import org.example.moduls.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByIngredientName(String ingredientName);
}
