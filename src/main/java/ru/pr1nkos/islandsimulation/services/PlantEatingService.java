package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.PlantEatingBehavior;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.pojo.Cell;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class PlantEatingService {

    private final PlantEatingBehavior plantEatingBehavior;
    private final PlantManagementService plantManagementService;
    private final RandomManager randomManager;
    private final IslandData islandData;
    private final List<Animal> animalsToFeed = new CopyOnWriteArrayList<>(); // Используем CopyOnWriteArrayList для безопасности

    public List<Animal> getAnimalsToFeed() {
        animalsToFeed.clear();
        Map<String, Cell> islandCells = islandData.getIslandCells();

        for (Cell cell : islandCells.values()) {
            for (Animal animal : cell.getAnimals()) {
                if (isHerbivore(animal) || isOmnivore(animal)) {
                    animalsToFeed.add(animal);
                }
            }
        }

        return animalsToFeed;
    }

    public void attemptToEatPlant(Animal herbivore) {
        while (herbivore.getFoodNeed() > 0) {
            Plant plant = findPlantForHerbivore(herbivore);

            if (plant == null || !plant.isAlive()) {
                break;
            }

            double chanceToEat = getChanceToEatPlant(herbivore);
            System.out.println(herbivore.getClass().getSimpleName().toLowerCase() +
                    " пытается съесть растение с шансом " + chanceToEat / 100);

            double randomValue = randomManager.nextDouble();

            if (randomValue < (chanceToEat / 100)) {
                System.out.println("Random value: " + randomValue);
                System.out.println("Chance to eat: " + chanceToEat / 100);
                eatPlant(herbivore, plant);

                herbivore.setFoodNeed(herbivore.getFoodNeed() - 1);
                herbivore.setWeight(herbivore.getWeight() + 1);
                System.out.println("Оставшаяся потребность в пище травоядного: " + herbivore.getFoodNeed());
            } else {
                System.out.println("Random value: " + randomValue);
                System.out.println("Chance to eat: " + chanceToEat / 100);
                System.out.println("Не удалось съесть растение");
            }

            if (herbivore.getFoodNeed() <= 0) {
                System.out.println("Травоядное сыто.");
                break;
            }
        }
    }

    private Integer getChanceToEatPlant(Animal herbivore) {
        return herbivore.getEatingChances().getOrDefault("plants", 0);
    }

    private Plant findPlantForHerbivore(Animal herbivore) {
        List<Plant> possiblePlants = plantManagementService.getPlantsAt(herbivore.getX(), herbivore.getY());
        return possiblePlants.isEmpty() ? null : randomManager.getRandomElement(possiblePlants);
    }

    private void eatPlant(Animal herbivore, Plant plant) {
        plantEatingBehavior.eatPlant(herbivore, plant);
        plantManagementService.removePlantFromIsland(plant);
    }

    private boolean isHerbivore(Animal animal) {
        for (HerbivoreType type : HerbivoreType.values()) {
            if (type.getType().equalsIgnoreCase(animal.getClass().getSimpleName().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private boolean isOmnivore(Animal animal) {
        for (OmnivoreType type : OmnivoreType.values()) {
            if (type.getType().equalsIgnoreCase(animal.getClass().getSimpleName().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
