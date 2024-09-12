package org.example.moduls.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long ingredientId;

    String ingredientName;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "storageId")
    StorageItem storage;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "ingredientsInCoffee",
            joinColumns = @JoinColumn(name = "ingredientId"),
            inverseJoinColumns = @JoinColumn(name = "coffeeId"))
    List<Coffee> coffeeList;
}
