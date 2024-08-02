package ru.pr1nkos.islandsimulation.entities.animals.herbivores;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.services.RandomManager;

import java.util.Map;

/**
 * The type Buffalo.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Buffalo extends Animal {

    /**
     * Instantiates a new Buffalo.
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
    public Buffalo(double baseWeight,
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
        return HerbivoreType.BUFFALO;
    }
}
