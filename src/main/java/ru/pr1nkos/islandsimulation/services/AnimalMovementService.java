package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.pojo.Cell;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class AnimalMovementService {

    private final DefaultMovingBehavior defaultMovingBehavior;
    private final IslandData islandData;

    public void moveAnimals() {
        Map<String, Cell> islandMap = islandData.getIslandCells();
        List<Animal> animalsToMove = new CopyOnWriteArrayList<>();

        for (Cell cell : islandMap.values()) {
            animalsToMove.addAll(cell.getAnimals());
        }

        for (Animal animal : animalsToMove) {
            defaultMovingBehavior.move(animal, islandMap);
        }
    }
}
