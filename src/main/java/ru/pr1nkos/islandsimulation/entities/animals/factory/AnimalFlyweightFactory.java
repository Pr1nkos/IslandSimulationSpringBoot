package ru.pr1nkos.islandsimulation.entities.animals.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.herbivores.*;
import ru.pr1nkos.islandsimulation.entities.animals.predators.*;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;
import ru.pr1nkos.islandsimulation.services.AnimalCharacteristicsService;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AnimalFlyweightFactory {
    private static final Map<String, Animal> predatorCache = new HashMap<>();
    private static final Map<String, Animal> herbivoreCache = new HashMap<>();
    private final BehaviorFactory behaviorFactory;
    private final AnimalCharacteristicsService animalCharacteristicsService;

    public Animal getAnimal(PredatorType predatorType) {
        String key = predatorType.name();
        if (!predatorCache.containsKey(key)) {
            predatorCache.put(key, createPredator(predatorType));
        }
        return predatorCache.get(key);
    }

    public Animal getAnimal(HerbivoreType herbivoreType) {
        String key = herbivoreType.name();
        if (!herbivoreCache.containsKey(key)) {
            herbivoreCache.put(key, createHerbivore(herbivoreType));
        }
        return herbivoreCache.get(key);
    }

    private Animal createPredator(PredatorType predatorType) {
        double baseWeight = animalCharacteristicsService.getBaseWeightForPredator(predatorType);
        int baseMaxCountPerLocation = animalCharacteristicsService.getBaseMaxCountPerLocationForPredator(predatorType);
        int baseMaxSpeed = animalCharacteristicsService.getBaseMaxSpeedForPredator(predatorType);
        double baseFoodNeeded = animalCharacteristicsService.getbaseFoodNeededForPredator(predatorType);
        Map<String, Integer> eatingChances = animalCharacteristicsService.getChancesForPredator(predatorType);
        return switch (predatorType) {
            case BEAR -> new Bear(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(predatorType.getType()),
                    behaviorFactory.getMovingBehavior(predatorType.getType()),
                    behaviorFactory.getReproducingBehavior(predatorType.getType()),
                    eatingChances
            );
            case BOA -> new Boa(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(predatorType.getType()),
                    behaviorFactory.getMovingBehavior(predatorType.getType()),
                    behaviorFactory.getReproducingBehavior(predatorType.getType()),
                    eatingChances
            );
            case EAGLE -> new Eagle(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(predatorType.getType()),
                    behaviorFactory.getMovingBehavior(predatorType.getType()),
                    behaviorFactory.getReproducingBehavior(predatorType.getType()),
                    eatingChances
            );
            case FOX -> new Fox(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(predatorType.getType()),
                    behaviorFactory.getMovingBehavior(predatorType.getType()),
                    behaviorFactory.getReproducingBehavior(predatorType.getType()),
                    eatingChances
            );
            case WOLF -> new Wolf(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(predatorType.getType()),
                    behaviorFactory.getMovingBehavior(predatorType.getType()),
                    behaviorFactory.getReproducingBehavior(predatorType.getType()),
                    eatingChances
            );
        };
    }

    private Animal createHerbivore(HerbivoreType herbivoreType) {
        Map<String, Integer> eatingChances = animalCharacteristicsService.getChancesForHerbivore(herbivoreType);
        double baseWeight = animalCharacteristicsService.getBaseWeightForHerbivore(herbivoreType);
        int baseMaxCountPerLocation = animalCharacteristicsService.getBaseMaxCountPerLocationForHerbivore(herbivoreType);
        int baseMaxSpeed = animalCharacteristicsService.getBaseMaxSpeedForHerbivore(herbivoreType);
        double baseFoodNeeded = animalCharacteristicsService.getbaseFoodNeededForHerbivore(herbivoreType);
        return switch (herbivoreType) {
            case BOAR -> new Boar(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
            case BUFFALO -> new Buffalo(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
            case CATERPILLAR -> new Caterpillar(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
            case DEER -> new Deer(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
            case DUCK -> new Duck(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
            case GOAT -> new Goat(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
            case HORSE -> new Horse(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
            case MOUSE -> new Mouse(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
            case RABBIT -> new Rabbit(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
            case SHEEP -> new Sheep(
                    baseWeight,
                    baseMaxCountPerLocation,
                    baseMaxSpeed,
                    baseFoodNeeded,
                    behaviorFactory.getEatingBehavior(herbivoreType.getType()),
                    behaviorFactory.getMovingBehavior(herbivoreType.getType()),
                    behaviorFactory.getReproducingBehavior(herbivoreType.getType()),
                    eatingChances
            );
        };
    }
}
