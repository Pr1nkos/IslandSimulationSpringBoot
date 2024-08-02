package ru.pr1nkos.islandsimulation.enums;

import lombok.Getter;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;

/**
 * The enum Omnivore type.
 */
@Getter
public enum OmnivoreType implements AnimalType {

    /**
     * Rabbit omnivore type.
     */
    RABBIT("rabbit"),

    /**
     * Goat omnivore type.
     */
    GOAT("goat"),

    /**
     * Boar omnivore type.
     */
    BOAR("boar"),

    /**
     * Duck omnivore type.
     */
    DUCK("duck");

    private final String type;

    OmnivoreType(String type) {
        this.type = type;
    }

}