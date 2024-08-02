package ru.pr1nkos.islandsimulation.enums;

import lombok.Getter;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;

/**
 * The enum Predator type.
 */
@Getter
public enum PredatorType implements AnimalType {
    /**
     * Wolf predator type.
     */
    WOLF("wolf"),
    /**
     * Boa predator type.
     */
    BOA("boa"),
    /**
     * Eagle predator type.
     */
    EAGLE("eagle"),
    /**
     * Fox predator type.
     */
    FOX("fox"),
    /**
     * Bear predator type.
     */
    BEAR("bear");

    private final String type;

    PredatorType(String type) {
        this.type = type;
    }


}

