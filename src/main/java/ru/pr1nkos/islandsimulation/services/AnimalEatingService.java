package ru.pr1nkos.islandsimulation.services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.PredatorEatingBehavior;
import ru.pr1nkos.islandsimulation.pojo.Cell;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class AnimalEatingService {

    private final AnimalManagementService animalManagementService;
    private final PredatorEatingBehavior predatorEatingBehavior;
    private final RandomManager randomManager;
    private final IslandData islandData;
    private final List<Animal> animalsToFeed = new CopyOnWriteArrayList<>();

    public synchronized List<Animal> getAnimalsToFeed() {
        List<Animal> animals = new ArrayList<>();
        Map<String, Cell> islandCells = islandData.getIslandCells();

        for (Cell cell : islandCells.values()) {
            animals.addAll(cell.getAnimals());
        }

        return animals;
    }

    public void attemptToEat(Animal predator) {
        do {
            Animal prey = findPreyForPredator(predator);

            if (prey == null || !prey.isAlive()) {
                break;
            }

            double chanceToEat = getChanceToEat(predator, prey);
            double randomValue = randomManager.nextDouble();

            if (randomValue < (chanceToEat / 100)) {
                System.out.println("Random value: " + randomValue);
                System.out.println("Chance to eat: " + chanceToEat / 100);
                eat(predator, prey);
                predator.setWeight(predator.getWeight() + prey.getWeight());
                predator.setFoodNeed(predator.getFoodNeed() - prey.getWeight());
                System.out.println("Predator's remaining food needed: " + predator.getFoodNeed());
            } else if (randomValue > (chanceToEat / 100) && chanceToEat != 0.0) {
                System.out.println("Random value: " + randomValue);
                System.out.println("Chance to eat: " + chanceToEat / 100);
                System.out.println("Prey escaped");
            }

            if (predator.getFoodNeed() <= 0) {
                System.out.println("Predator is full.");
                break;
            }
        } while (true);
    }

    private Integer getChanceToEat(Animal predator, Animal prey) {
        return predator.getEatingChances().getOrDefault(prey.getClass().getSimpleName().toLowerCase(), 0);
    }

    private synchronized Animal findPreyForPredator(Animal predator) {
        List<Animal> possiblePreys = new ArrayList<>(animalManagementService.getAnimalsAt(predator.getX(), predator.getY()));
        possiblePreys.remove(predator);

        if (possiblePreys.isEmpty()) {
            return null;
        }

        return randomManager.getRandomElement(possiblePreys);
    }

    private void eat(Animal predator, Animal prey) {
        predatorEatingBehavior.eat(predator, prey);
        animalManagementService.removeAnimalFromIsland(prey);
    }
}
