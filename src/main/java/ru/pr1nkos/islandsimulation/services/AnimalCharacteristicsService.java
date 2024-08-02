package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.dto.AnimalCharacteristicsDto;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;

import java.util.Map;

/**
 * The type Animal characteristics service.
 */
@Service
@RequiredArgsConstructor
public class AnimalCharacteristicsService {
    private final AnimalCharacteristicsDto animalCharacteristicsDto;

    /**
     * Gets chances for predator.
     *
     * @param predatorType the predator type
     * @return the chances for predator
     */
    public Map<String, Integer> getChancesForPredator(PredatorType predatorType) {
        return switch (predatorType) {
            case WOLF -> animalCharacteristicsDto.getWolf().getEatingChances();
            case BOA -> animalCharacteristicsDto.getBoa().getEatingChances();
            case FOX -> animalCharacteristicsDto.getFox().getEatingChances();
            case BEAR -> animalCharacteristicsDto.getBear().getEatingChances();
            case EAGLE -> animalCharacteristicsDto.getEagle().getEatingChances();
        };
    }

    /**
     * Gets chances for herbivore.
     *
     * @param herbivoreType the herbivore type
     * @return the chances for herbivore
     */
    public Map<String, Integer> getChancesForHerbivore(HerbivoreType herbivoreType) {
        return switch (herbivoreType) {
            case HORSE -> animalCharacteristicsDto.getHorse().getEatingChances();
            case DEER -> animalCharacteristicsDto.getDeer().getEatingChances();
            case MOUSE -> animalCharacteristicsDto.getMouse().getEatingChances();
            case SHEEP -> animalCharacteristicsDto.getSheep().getEatingChances();
            case BUFFALO -> animalCharacteristicsDto.getBuffalo().getEatingChances();
            case CATERPILLAR -> animalCharacteristicsDto.getCaterpillar().getEatingChances();
        };
    }

    /**
     * Gets chances for omnivores.
     *
     * @param omnivoreType the omnivore type
     * @return the chances for omnivores
     */
    public Map<String, Integer> getChancesForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType) {
            case RABBIT -> animalCharacteristicsDto.getRabbit().getEatingChances();
            case GOAT -> animalCharacteristicsDto.getGoat().getEatingChances();
            case BOAR -> animalCharacteristicsDto.getBoar().getEatingChances();
            case DUCK -> animalCharacteristicsDto.getDuck().getEatingChances();
        };
    }

    /**
     * Gets base weight for predator.
     *
     * @param predatorType the predator type
     * @return the base weight for predator
     */
    public double getBaseWeightForPredator(PredatorType predatorType) {
        return switch (predatorType){
            case WOLF -> animalCharacteristicsDto.getWolf().getBaseWeight();
            case BOA -> animalCharacteristicsDto.getBoa().getBaseWeight();
            case FOX -> animalCharacteristicsDto.getFox().getBaseWeight();
            case BEAR -> animalCharacteristicsDto.getBear().getBaseWeight();
            case EAGLE -> animalCharacteristicsDto.getEagle().getBaseWeight();
        };
    }

    /**
     * Gets base weight for herbivore.
     *
     * @param herbivoreType the herbivore type
     * @return the base weight for herbivore
     */
    public double getBaseWeightForHerbivore(HerbivoreType herbivoreType) {
        return switch (herbivoreType){
            case HORSE -> animalCharacteristicsDto.getHorse().getBaseWeight();
            case DEER -> animalCharacteristicsDto.getDeer().getBaseWeight();
            case MOUSE -> animalCharacteristicsDto.getMouse().getBaseWeight();
            case SHEEP -> animalCharacteristicsDto.getSheep().getBaseWeight();
            case BUFFALO -> animalCharacteristicsDto.getBuffalo().getBaseWeight();
            case CATERPILLAR -> animalCharacteristicsDto.getCaterpillar().getBaseWeight();
        };
    }

    /**
     * Gets base weight for omnivores.
     *
     * @param omnivoreType the omnivore type
     * @return the base weight for omnivores
     */
    public double getBaseWeightForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType){
            case RABBIT -> animalCharacteristicsDto.getRabbit().getBaseWeight();
            case GOAT -> animalCharacteristicsDto.getGoat().getBaseWeight();
            case BOAR -> animalCharacteristicsDto.getBoar().getBaseWeight();
            case DUCK -> animalCharacteristicsDto.getDuck().getBaseWeight();
        };
    }


    /**
     * Get base max count per location for predator int.
     *
     * @param predatorType the predator type
     * @return the int
     */
    public int getBaseMaxCountPerLocationForPredator(PredatorType predatorType){
        return switch (predatorType){
            case WOLF -> animalCharacteristicsDto.getWolf().getBaseMaxCountPerLocation();
            case BOA -> animalCharacteristicsDto.getBoa().getBaseMaxCountPerLocation();
            case FOX -> animalCharacteristicsDto.getFox().getBaseMaxCountPerLocation();
            case BEAR -> animalCharacteristicsDto.getBear().getBaseMaxCountPerLocation();
            case EAGLE -> animalCharacteristicsDto.getEagle().getBaseMaxCountPerLocation();
        };
    }

    /**
     * Gets base max count per location for herbivore.
     *
     * @param herbivoreType the herbivore type
     * @return the base max count per location for herbivore
     */
    public int getBaseMaxCountPerLocationForHerbivore(HerbivoreType herbivoreType) {
        return switch (herbivoreType){
            case HORSE -> animalCharacteristicsDto.getHorse().getBaseMaxCountPerLocation();
            case DEER -> animalCharacteristicsDto.getDeer().getBaseMaxCountPerLocation();
            case MOUSE -> animalCharacteristicsDto.getMouse().getBaseMaxCountPerLocation();
            case SHEEP -> animalCharacteristicsDto.getSheep().getBaseMaxCountPerLocation();
            case BUFFALO -> animalCharacteristicsDto.getBuffalo().getBaseMaxCountPerLocation();
            case CATERPILLAR -> animalCharacteristicsDto.getCaterpillar().getBaseMaxCountPerLocation();
        };
    }

    /**
     * Gets base max count per location for omnivores.
     *
     * @param omnivoreType the omnivore type
     * @return the base max count per location for omnivores
     */
    public int getBaseMaxCountPerLocationForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType){
            case RABBIT -> animalCharacteristicsDto.getRabbit().getBaseMaxCountPerLocation();
            case GOAT -> animalCharacteristicsDto.getGoat().getBaseMaxCountPerLocation();
            case BOAR -> animalCharacteristicsDto.getBoar().getBaseMaxCountPerLocation();
            case DUCK -> animalCharacteristicsDto.getDuck().getBaseMaxCountPerLocation();
        };
    }

    /**
     * Get base max speed for predator int.
     *
     * @param predatorType the predator type
     * @return the int
     */
    public int getBaseMaxSpeedForPredator(PredatorType predatorType){
        return switch (predatorType){
            case WOLF -> animalCharacteristicsDto.getWolf().getBaseMaxSpeed();
            case BOA -> animalCharacteristicsDto.getBoa().getBaseMaxSpeed();
            case FOX -> animalCharacteristicsDto.getFox().getBaseMaxSpeed();
            case BEAR -> animalCharacteristicsDto.getBear().getBaseMaxSpeed();
            case EAGLE -> animalCharacteristicsDto.getEagle().getBaseMaxSpeed();
        };
    }

    /**
     * Gets base max speed for herbivore.
     *
     * @param herbivoreType the herbivore type
     * @return the base max speed for herbivore
     */
    public int getBaseMaxSpeedForHerbivore(HerbivoreType herbivoreType) {
        return switch (herbivoreType){
            case HORSE -> animalCharacteristicsDto.getHorse().getBaseMaxSpeed();
            case DEER -> animalCharacteristicsDto.getDeer().getBaseMaxSpeed();
            case MOUSE -> animalCharacteristicsDto.getMouse().getBaseMaxSpeed();
            case SHEEP -> animalCharacteristicsDto.getSheep().getBaseMaxSpeed();
            case BUFFALO -> animalCharacteristicsDto.getBuffalo().getBaseMaxSpeed();
            case CATERPILLAR -> animalCharacteristicsDto.getCaterpillar().getBaseMaxSpeed();
        };
    }

    /**
     * Gets base max speed for omnivores.
     *
     * @param omnivoreType the omnivore type
     * @return the base max speed for omnivores
     */
    public int getBaseMaxSpeedForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType){
            case RABBIT -> animalCharacteristicsDto.getRabbit().getBaseMaxSpeed();
            case GOAT -> animalCharacteristicsDto.getGoat().getBaseMaxSpeed();
            case BOAR -> animalCharacteristicsDto.getBoar().getBaseMaxSpeed();
            case DUCK -> animalCharacteristicsDto.getDuck().getBaseMaxSpeed();
        };
    }

    /**
     * Gets food needed for predator.
     *
     * @param predatorType the predator type
     * @return the food needed for predator
     */
    public double getbaseFoodNeededForPredator(PredatorType predatorType) {
        return switch (predatorType){
            case WOLF -> animalCharacteristicsDto.getWolf().getBaseFoodNeeded();
            case BOA -> animalCharacteristicsDto.getBoa().getBaseFoodNeeded();
            case FOX -> animalCharacteristicsDto.getFox().getBaseFoodNeeded();
            case BEAR -> animalCharacteristicsDto.getBear().getBaseFoodNeeded();
            case EAGLE -> animalCharacteristicsDto.getEagle().getBaseFoodNeeded();
        };
    }

    /**
     * Gets food needed for herbivore.
     *
     * @param herbivoreType the herbivore type
     * @return the food needed for herbivore
     */
    public double getbaseFoodNeededForHerbivore(HerbivoreType herbivoreType) {
        return switch (herbivoreType){
            case HORSE -> animalCharacteristicsDto.getHorse().getBaseFoodNeeded();
            case DEER -> animalCharacteristicsDto.getDeer().getBaseFoodNeeded();
            case MOUSE -> animalCharacteristicsDto.getMouse().getBaseFoodNeeded();
            case SHEEP -> animalCharacteristicsDto.getSheep().getBaseFoodNeeded();
            case BUFFALO -> animalCharacteristicsDto.getBuffalo().getBaseFoodNeeded();
            case CATERPILLAR -> animalCharacteristicsDto.getCaterpillar().getBaseFoodNeeded();
        };
    }

    /**
     * Gets food needed for omnivores.
     *
     * @param omnivoreType the omnivore type
     * @return the food needed for omnivores
     */
    public double getbaseFoodNeededForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType){
            case RABBIT -> animalCharacteristicsDto.getRabbit().getBaseFoodNeeded();
            case GOAT -> animalCharacteristicsDto.getGoat().getBaseFoodNeeded();
            case BOAR -> animalCharacteristicsDto.getBoar().getBaseFoodNeeded();
            case DUCK -> animalCharacteristicsDto.getDuck().getBaseFoodNeeded();
        };
    }



}
