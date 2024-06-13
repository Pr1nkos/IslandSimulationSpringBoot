package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AnimalMovementService {

    private final Random random = new Random();
    private final IslandData islandData;

    public void moveAnimals() {
        Map<String, List<Animal>> islandMap = islandData.getIslandMap();
        List<AnimalMovement> movements = new ArrayList<>();

        for (Map.Entry<String, List<Animal>> entry : islandMap.entrySet()) {
            String key = entry.getKey();
            List<Animal> animals = entry.getValue();

            for (Animal animal : animals) {
                movements.add(new AnimalMovement(animal, key, getRandomNeighbor(key, animal.getMaxSpeed())));
            }
        }

        for (AnimalMovement movement : movements) {
            List<Animal> currentCell = islandMap.get(movement.currentKey);
            List<Animal> newCell = islandMap.get(movement.newKey);

            currentCell.remove(movement.animal);
            newCell.add(movement.animal);
        }
    }

    private String getRandomNeighbor(String key, int maxSpeed) {
        String[] parts = key.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        int newX = x + random.nextInt(2 * maxSpeed + 1) - maxSpeed;
        int newY = y + random.nextInt(2 * maxSpeed + 1) - maxSpeed;

        newX = Math.max(0, Math.min(newX, 99));
        newY = Math.max(0, Math.min(newY, 19));

        return newX + "," + newY;
    }

    private static class AnimalMovement {
        Animal animal;
        String currentKey;
        String newKey;

        AnimalMovement(Animal animal, String currentKey, String newKey) {
            this.animal = animal;
            this.currentKey = currentKey;
            this.newKey = newKey;
        }
    }
}
