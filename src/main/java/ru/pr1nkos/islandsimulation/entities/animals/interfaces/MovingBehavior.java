package ru.pr1nkos.islandsimulation.entities.animals.interfaces;

import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.island.Cell;

import java.util.Map;

/**
 * The interface Moving behavior.
 */
public interface MovingBehavior {
    /**
     * Move.
     *
     * @param animal    the animal
     * @param islandMap the island map
     */
    void move(Animal animal, Map<String, Cell> islandMap);
}
