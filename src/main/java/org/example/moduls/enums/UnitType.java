package org.example.moduls.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UnitType {

    GRAM("г"),
    MILLILITER("мл");
    private String name;

    UnitType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
