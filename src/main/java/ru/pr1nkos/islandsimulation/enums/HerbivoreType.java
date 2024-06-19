package ru.pr1nkos.islandsimulation.enums;

import lombok.Getter;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;

@Getter
public enum HerbivoreType implements AnimalType {
    HORSE("horse"),
    DEER("deer"),

    MOUSE("mouse"),

    SHEEP("sheep"),

    BUFFALO("buffalo"),

    CATERPILLAR("caterpillar");

    private final String type;

    HerbivoreType(String type) {
        this.type = type;
    }
}