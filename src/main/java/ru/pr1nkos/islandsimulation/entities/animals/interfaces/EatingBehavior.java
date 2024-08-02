package ru.pr1nkos.islandsimulation.entities.animals.interfaces;

import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;

/**
 * The interface Eating behavior.
 */
public interface EatingBehavior {
    /**
     * Eat.
     *
     * @param predator the predator
     * @param prey     the prey
     */
    void eat(Animal predator, Animal prey);

    /**
     * Eat plant.
     *
     * @param herbivore the herbivore
     * @param plant     the plant
     */
    void eatPlant(Animal herbivore, Plant plant);
}
