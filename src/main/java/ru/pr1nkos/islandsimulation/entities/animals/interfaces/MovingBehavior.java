package ru.pr1nkos.islandsimulation.entities.animals.interfaces;

import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.pojo.Cell;

import java.util.Map;

public interface MovingBehavior {
    void move(Animal animal, Map<String, Cell> islandMap);
}
