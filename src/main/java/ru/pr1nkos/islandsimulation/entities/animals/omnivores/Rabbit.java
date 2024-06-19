package ru.pr1nkos.islandsimulation.entities.animals.omnivores;


import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.services.RandomManager;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data

public class Rabbit extends Animal {



    public Rabbit
            (double baseWeight,
             int baseMaxCountPerLocation,
             int baseMaxSpeed,
             double baseFoodNeeded,
             EatingBehavior eatingBehavior,
             MovingBehavior movingBehavior,
             ReproducingBehavior reproducingBehavior,
             Map<String, Integer> eatingChances,
             RandomManager randomManager) {
        super(baseWeight,
                baseMaxCountPerLocation,
                baseMaxSpeed,
                baseFoodNeeded,
                eatingBehavior,
                movingBehavior,
                reproducingBehavior,
                eatingChances,
                randomManager);
    }

    @Override
    public AnimalType getAnimalType() {
        return OmnivoreType.RABBIT;
    }

}