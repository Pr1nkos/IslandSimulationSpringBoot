package ru.pr1nkos.islandsimulation.services;

import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class AnimalMovementService {

    private final IslandService islandService;
    private final Random random = new Random();

    public AnimalMovementService(IslandService islandService) {
        this.islandService = islandService;
    }

    public void moveAnimals() {
        Map<String, List<Animal>> islandMap = islandService.getIslandMap();
        List<AnimalMovement> movements = new ArrayList<>();

        for (Map.Entry<String, List<Animal>> entry : islandMap.entrySet()) {
            String key = entry.getKey();
            List<Animal> animals = entry.getValue();

            for (Animal animal : animals) {
                // Убираем животное из текущей клетки
                movements.add(new AnimalMovement(animal, key, getRandomNeighbor(key)));
            }
        }

        // Применяем все движения после завершения итерации
        for (AnimalMovement movement : movements) {
            List<Animal> currentCell = islandMap.get(movement.currentKey);
            List<Animal> newCell = islandMap.get(movement.newKey);

            currentCell.remove(movement.animal);
            newCell.add(movement.animal);
        }
    }

    private String getRandomNeighbor(String key) {
        String[] parts = key.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        int newX = x + random.nextInt(3) - 1; // -1, 0, 1
        int newY = y + random.nextInt(3) - 1; // -1, 0, 1

        newX = Math.max(0, Math.min(99, newX)); // Остров ограничен размером 100x20
        newY = Math.max(0, Math.min(19, newY));

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
