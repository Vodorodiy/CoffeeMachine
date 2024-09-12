package org.example.moduls.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@jsonID")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long coffeeId;

    String coffeeName;

    String recipe;

    int clickCount = 0;

    @ManyToMany(mappedBy = "coffeeList",cascade=CascadeType.ALL)
    List<Ingredient> ingredients;

    public Coffee(String coffeeName, String recipe, List<Ingredient> ingredients) {
        this.coffeeName = coffeeName;
        this.recipe = recipe;
    }
}
