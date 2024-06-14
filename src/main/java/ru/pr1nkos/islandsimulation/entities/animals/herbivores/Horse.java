package ru.pr1nkos.islandsimulation.entities.animals.herbivores;


import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data

public class Horse extends Animal {


    public Horse(double baseWeight,
                 int baseMaxCountPerLocation,
                 int baseMaxSpeed,
                 double baseFoodNeeded,
                 EatingBehavior eatingBehavior,
                 MovingBehavior movingBehavior,
                 ReproducingBehavior reproducingBehavior, Map<String, Integer> eatingChances) {
        super(baseWeight,
                baseMaxCountPerLocation,
                baseMaxSpeed,
                baseFoodNeeded,
                eatingBehavior,
                movingBehavior,
                reproducingBehavior,
                eatingChances);
    }
}
