package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.entities.island.Cell;
import ru.pr1nkos.islandsimulation.entities.island.IslandData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The type Animal movement service.
 */
@Service
@RequiredArgsConstructor

public class AnimalMovementService {

    private final DefaultMovingBehavior defaultMovingBehavior;
    private final IslandData islandData;

    /**
     * Move animals.
     */
    @SneakyThrows
    public void moveAnimals() {
        Map<String, Cell> islandMap = islandData.getIslandCells();
        List<Animal> animalsToMove = new CopyOnWriteArrayList<>();
        islandMap.values().forEach(cell -> {
            List<Animal> animalsInCell = cell.getAnimals();
            if (animalsInCell != null) {
                animalsToMove.addAll(animalsInCell);
            }
        });
        animalsToMove.forEach(animal -> defaultMovingBehavior.move(animal,islandMap));

    }
}
