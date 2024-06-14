package ru.pr1nkos.islandsimulation.entities.animals.herbivores;


import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;

import java.util.Map;

public class Duck extends Animal {

    public Duck(double baseWeight,
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
