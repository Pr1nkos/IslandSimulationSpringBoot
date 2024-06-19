package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.PredatorEatingBehavior;
import ru.pr1nkos.islandsimulation.pojo.Cell;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class AnimalEatingService {

    private final AnimalManagementService animalManagementService;
    private final PredatorEatingBehavior predatorEatingBehavior;
    private final Random random = new Random();
    private final IslandData islandData;
    private final List<Animal> animalsToFeed = new CopyOnWriteArrayList<>(); // Используем CopyOnWriteArrayList для безопасности


    public List<Animal> getAnimalsToFeed() {
        animalsToFeed.clear();
        Map<String, Cell> islandCells = islandData.getIslandCells();

        // Перебираем все ячейки острова
        for (Cell cell : islandCells.values()) {
            animalsToFeed.addAll(cell.getAnimals());
        }

        return animalsToFeed;
    }


    public void attemptToEat(Animal predator) {
        Animal prey = findPreyForPredator(predator);

        if (prey != null && prey.isAlive()) {
            double chanceToEat = getChanceToEat(predator, prey);
            System.out.println(predator.getClass().getSimpleName().toLowerCase() +
                    prey.getClass().getSimpleName().toLowerCase() + " " + chanceToEat / 100);

            double randomValue = random.nextDouble();

            if (randomValue < (chanceToEat / 100)) {
                System.out.println("Random value: " + randomValue);
                System.out.println("Chance to eat: " + chanceToEat / 100);
                eat(predator, prey);
            }
            else if (randomValue > (chanceToEat / 100) && chanceToEat != 0.0) {
                System.out.println("Random value: " + randomValue);
                System.out.println("Chance to eat: " + chanceToEat / 100);
                System.out.println("Добыча сбежала");
            }
        }
    }

    private Integer getChanceToEat(Animal predator, Animal prey) {
        return predator.getEatingChances().getOrDefault(prey.getClass().getSimpleName().toLowerCase(), 0);
    }

    private Animal findPreyForPredator(Animal predator) {
        List<Animal> possiblePreys = animalManagementService.getAnimalsAt(predator.getX(), predator.getY());
        possiblePreys.remove(predator);
        return possiblePreys.isEmpty() ? null : possiblePreys.get(random.nextInt(possiblePreys.size()));
    }

    private void eat(Animal predator, Animal prey) {
        predatorEatingBehavior.eat(predator, prey);
        animalManagementService.removeAnimalFromIsland(prey);
    }

}
