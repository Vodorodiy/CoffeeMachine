package org.example.moduls.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.moduls.enums.UnitType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long storageId;

    @JsonIgnore
    @OneToOne(mappedBy = "storage")
    Ingredient ingredient;

    String ingredientName;

    int unitCount;

    @Enumerated(EnumType.STRING)
    UnitType unitType;
}
