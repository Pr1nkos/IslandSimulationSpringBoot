package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultEatingBehavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AnimalEatingService {

    private final AnimalManagementService animalManagementService;
    private final DefaultEatingBehavior defaultEatingBehavior;
    private final Random random = new Random();

    public List<Animal> getAnimalsToFeed() {
        return new ArrayList<>(animalManagementService.getAnimals());
    }

    public void attemptToEat(Animal predator) {
        Animal prey = findPreyForPredator(predator);

        if (prey != null && prey.isAlive()) {
            double chanceToEat = getChanceToEat(predator, prey);
            //Для отладки
            System.out.println(predator.getClass().getSimpleName().toLowerCase() + prey.getClass().getSimpleName().toLowerCase() + " " + chanceToEat / 100);
            double randomValue = random.nextDouble(1);
            if (randomValue < (chanceToEat / 100)) {
                System.out.println(randomValue);
                System.out.println(chanceToEat / 100);
                eat(predator, prey);
            }
            else if (randomValue > (chanceToEat / 100) && chanceToEat != 0.0) {
                System.out.println(randomValue);
                System.out.println(chanceToEat / 100);
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
        // Выполняем поведение поедания
        defaultEatingBehavior.eat(predator, prey);

        // После поедания вызываем метод для удаления съеденного животного с острова
        animalManagementService.removeAnimalFromIsland(prey);
    }
}
