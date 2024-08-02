package ru.pr1nkos.islandsimulation.enums;

import lombok.Getter;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;

/**
 * The enum Herbivore type.
 */
@Getter
public enum HerbivoreType implements AnimalType {
    /**
     * Horse herbivore type.
     */
    HORSE("horse"),
    /**
     * Deer herbivore type.
     */
    DEER("deer"),

    /**
     * Mouse herbivore type.
     */
    MOUSE("mouse"),

    /**
     * Sheep herbivore type.
     */
    SHEEP("sheep"),

    /**
     * Buffalo herbivore type.
     */
    BUFFALO("buffalo"),

    /**
     * Caterpillar herbivore type.
     */
    CATERPILLAR("caterpillar");

    private final String type;

    HerbivoreType(String type) {
        this.type = type;
    }
}