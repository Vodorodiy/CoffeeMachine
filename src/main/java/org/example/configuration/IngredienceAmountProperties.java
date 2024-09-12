package org.example.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.moduls.entity.Ingredient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@ConfigurationProperties(prefix = "recipe")
@Data
@AllArgsConstructor
public class IngredienceAmountProperties {
    HashMap<String, HashMap<String, Integer>> recipe;
}
