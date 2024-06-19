package ru.pr1nkos.islandsimulation.entities.animals.behaviors;

import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.pojo.Cell;

import java.util.Map;
import java.util.Random;

@Component
public class DefaultMovingBehavior implements MovingBehavior {
    private final Random random = new Random();

    @Override
    public void move(Animal animal, Map<String, Cell> islandMap) {
        String currentKey = findCurrentPosition(animal, islandMap);
        if (animal.getMaxSpeed() == 0) {
            System.out.println("This animal cannot move because maxSpeed is 0.");
        } else {
            String newKey = getRandomNeighbor(currentKey, animal.getMaxSpeed());
            if (currentKey != null && islandMap.containsKey(newKey)) {
                Cell currentCell = islandMap.get(currentKey);
                Cell newCell = islandMap.get(newKey);
                if (newCell.getAnimals().size() < animal.getBaseMaxCountPerLocation()) {
                    currentCell.removeAnimal(animal);
                    newCell.addAnimal(animal);
                } else {
                    System.out.println("Cannot add animal. Max count per location exceeded.");
                }
            }
        }
    }

    private String findCurrentPosition(Animal animal, Map<String, Cell> islandMap) {
        for (Map.Entry<String, Cell> entry : islandMap.entrySet()) {
            if (entry.getValue().getAnimals().contains(animal)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private String getRandomNeighbor(String key, int maxSpeed) {
        if (key == null) {
            return null;
        }

        String[] parts = key.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        if (maxSpeed <= 0) {
            return x + "," + y;
        }

        maxSpeed = Math.max(1, maxSpeed);

        int minX = Math.max(0, x - maxSpeed);
        int maxX = Math.min(99, x + maxSpeed);
        int minY = Math.max(0, y - maxSpeed);
        int maxY = Math.min(19, y + maxSpeed);

        if (maxX - minX <= 0 || maxY - minY <= 0) {
            return x + "," + y; // Возвращаем текущее положение, если не можем генерировать новую позицию
        }

        int newX = minX + random.nextInt(maxX - minX + 1);
        int newY = minY + random.nextInt(maxY - minY + 1);

        return newX + "," + newY;
    }
}
