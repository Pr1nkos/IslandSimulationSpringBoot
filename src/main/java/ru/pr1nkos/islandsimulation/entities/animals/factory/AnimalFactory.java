package ru.pr1nkos.islandsimulation.entities.animals.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;

/**
 * The type Animal factory.
 */
@Component
@RequiredArgsConstructor
public class AnimalFactory {

    private final AnimalFlyweightFactory animalFlyweightFactory;

    /**
     * Create animal animal.
     *
     * @param predatorType the predator type
     * @return the animal
     */
    public Animal createAnimal(PredatorType predatorType) {
        return animalFlyweightFactory.getAnimal(predatorType);
    }

    /**
     * Create animal animal.
     *
     * @param herbivoreType the herbivore type
     * @return the animal
     */
    public Animal createAnimal(HerbivoreType herbivoreType) {
        return animalFlyweightFactory.getAnimal(herbivoreType);
    }

    /**
     * Create animal animal.
     *
     * @param omnivoreType the omnivore type
     * @return the animal
     */
    public Animal createAnimal(OmnivoreType omnivoreType) {
        return animalFlyweightFactory.getAnimal(omnivoreType);
    }

}
