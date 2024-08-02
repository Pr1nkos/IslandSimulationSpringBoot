package ru.pr1nkos.islandsimulation.entities.animals.predators;


import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;
import ru.pr1nkos.islandsimulation.enums.PredatorType;
import ru.pr1nkos.islandsimulation.services.RandomManager;

import java.util.Map;

/**
 * The type Bear.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Bear extends Animal {


    /**
     * Instantiates a new Bear.
     *
     * @param baseWeight              the base weight
     * @param baseMaxCountPerLocation the base max count per location
     * @param baseMaxSpeed            the base max speed
     * @param baseFoodNeeded          the base food needed
     * @param eatingBehavior          the eating behavior
     * @param movingBehavior          the moving behavior
     * @param reproducingBehavior     the reproducing behavior
     * @param eatingChances           the eating chances
     * @param randomManager           the random manager
     */
    public Bear
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
        return PredatorType.BEAR;
    }
}