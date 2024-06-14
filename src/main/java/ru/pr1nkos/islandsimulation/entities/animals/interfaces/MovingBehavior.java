package ru.pr1nkos.islandsimulation.entities.animals.interfaces;

import ru.pr1nkos.islandsimulation.entities.animals.Animal;

import java.util.List;
import java.util.Map;

public interface MovingBehavior {
    void move(Animal animal, Map<String, List<Animal>> islandMap);
}
