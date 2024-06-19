package ru.pr1nkos.islandsimulation.enums;

import lombok.Getter;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;

@Getter
public enum OmnivoreType implements AnimalType {

    RABBIT("rabbit"),

    GOAT("goat"),

    BOAR("boar"),

    DUCK("duck");

    private final String type;

    OmnivoreType(String type) {
        this.type = type;
    }

}