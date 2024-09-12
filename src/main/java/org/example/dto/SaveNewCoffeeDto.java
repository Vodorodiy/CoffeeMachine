package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveNewCoffeeDto {
    String coffeeName;
    String recipe;
    List<String> ingredientList;
}