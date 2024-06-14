package ru.pr1nkos.islandsimulation.entities.animals.behaviors;

import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class DefaultMovingBehavior implements MovingBehavior {
    private final Random random = new Random();

    @Override
    public void move(Animal animal, Map<String, List<Animal>> islandMap) {
        String currentKey = findCurrentPosition(animal, islandMap);
        if (animal.getMaxSpeed() == 0) {
            System.out.println("This animal cannot move because maxSpeed is 0.");
        } else {
            String newKey = getRandomNeighbor(currentKey, animal.getMaxSpeed());
            if (currentKey != null && islandMap.containsKey(newKey)) {
                List<Animal> animalsInNewCell = islandMap.get(newKey);
                if (animalsInNewCell.size() < animal.getBaseMaxCountPerLocation()) {

                    islandMap.get(currentKey).remove(animal);
                    islandMap.get(newKey).add(animal);
                } else {
                    System.out.println("Cannot add animal. Max count per location exceeded.");

                }
            }
        }
    }


    private String findCurrentPosition(Animal animal, Map<String, List<Animal>> islandMap) {
        for (Map.Entry<String, List<Animal>> entry : islandMap.entrySet()) {
            if (entry.getValue().contains(animal)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private String getRandomNeighbor(String key, int maxSpeed) {
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
