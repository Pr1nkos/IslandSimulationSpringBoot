package ru.pr1nkos.islandsimulation.enums;

import lombok.Getter;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;

@Getter
public enum PredatorType implements AnimalType {
    WOLF("wolf"),
    BOA("boa"),
    EAGLE("eagle"),
    FOX("fox"),
    BEAR("bear");

    private final String type;

    PredatorType(String type) {
        this.type = type;
    }


}

