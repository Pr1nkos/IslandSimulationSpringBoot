package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class AnimalMovementService {

    private final IslandData islandData;


    public void moveAnimals() {
        Map<String, List<Animal>> islandMap = islandData.getIslandMap();

        for (Map.Entry<String, List<Animal>> entry : islandMap.entrySet()) {
            List<Animal> animals = new CopyOnWriteArrayList<>(entry.getValue());

            for (Animal animal : animals) {
                animal.getMovingBehavior().move(animal, islandMap);
            }
        }
    }
}
