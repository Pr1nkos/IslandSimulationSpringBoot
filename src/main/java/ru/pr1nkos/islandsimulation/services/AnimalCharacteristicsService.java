package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.dto.AnimalCharacteristicsDto;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnimalCharacteristicsService {
    private final AnimalCharacteristicsDto animalCharacteristicsDto;

    public Map<String, Integer> getChancesForPredator(PredatorType predatorType) {
        return switch (predatorType) {
            case WOLF -> animalCharacteristicsDto.getWolf().getEatingChances();
            case BOA -> animalCharacteristicsDto.getBoa().getEatingChances();
            case FOX -> animalCharacteristicsDto.getFox().getEatingChances();
            case BEAR -> animalCharacteristicsDto.getBear().getEatingChances();
            case EAGLE -> animalCharacteristicsDto.getEagle().getEatingChances();
        };
    }

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

    public Map<String, Integer> getChancesForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType) {
            case RABBIT -> animalCharacteristicsDto.getRabbit().getEatingChances();
            case GOAT -> animalCharacteristicsDto.getGoat().getEatingChances();
            case BOAR -> animalCharacteristicsDto.getBoar().getEatingChances();
            case DUCK -> animalCharacteristicsDto.getDuck().getEatingChances();
        };
    }

    public double getBaseWeightForPredator(PredatorType predatorType) {
        return switch (predatorType){
            case WOLF -> animalCharacteristicsDto.getWolf().getBaseWeight();
            case BOA -> animalCharacteristicsDto.getBoa().getBaseWeight();
            case FOX -> animalCharacteristicsDto.getFox().getBaseWeight();
            case BEAR -> animalCharacteristicsDto.getBear().getBaseWeight();
            case EAGLE -> animalCharacteristicsDto.getEagle().getBaseWeight();
        };
    }

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

    public double getBaseWeightForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType){
            case RABBIT -> animalCharacteristicsDto.getRabbit().getBaseWeight();
            case GOAT -> animalCharacteristicsDto.getGoat().getBaseWeight();
            case BOAR -> animalCharacteristicsDto.getBoar().getBaseWeight();
            case DUCK -> animalCharacteristicsDto.getDuck().getBaseWeight();
        };
    }


    public int getBaseMaxCountPerLocationForPredator(PredatorType predatorType){
        return switch (predatorType){
            case WOLF -> animalCharacteristicsDto.getWolf().getBaseMaxCountPerLocation();
            case BOA -> animalCharacteristicsDto.getBoa().getBaseMaxCountPerLocation();
            case FOX -> animalCharacteristicsDto.getFox().getBaseMaxCountPerLocation();
            case BEAR -> animalCharacteristicsDto.getBear().getBaseMaxCountPerLocation();
            case EAGLE -> animalCharacteristicsDto.getEagle().getBaseMaxCountPerLocation();
        };
    }

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

    public int getBaseMaxCountPerLocationForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType){
            case RABBIT -> animalCharacteristicsDto.getRabbit().getBaseMaxCountPerLocation();
            case GOAT -> animalCharacteristicsDto.getGoat().getBaseMaxCountPerLocation();
            case BOAR -> animalCharacteristicsDto.getBoar().getBaseMaxCountPerLocation();
            case DUCK -> animalCharacteristicsDto.getDuck().getBaseMaxCountPerLocation();
        };
    }
    public int getBaseMaxSpeedForPredator(PredatorType predatorType){
        return switch (predatorType){
            case WOLF -> animalCharacteristicsDto.getWolf().getBaseMaxSpeed();
            case BOA -> animalCharacteristicsDto.getBoa().getBaseMaxSpeed();
            case FOX -> animalCharacteristicsDto.getFox().getBaseMaxSpeed();
            case BEAR -> animalCharacteristicsDto.getBear().getBaseMaxSpeed();
            case EAGLE -> animalCharacteristicsDto.getEagle().getBaseMaxSpeed();
        };
    }

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

    public int getBaseMaxSpeedForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType){
            case RABBIT -> animalCharacteristicsDto.getRabbit().getBaseMaxSpeed();
            case GOAT -> animalCharacteristicsDto.getGoat().getBaseMaxSpeed();
            case BOAR -> animalCharacteristicsDto.getBoar().getBaseMaxSpeed();
            case DUCK -> animalCharacteristicsDto.getDuck().getBaseMaxSpeed();
        };
    }

    public double getbaseFoodNeededForPredator(PredatorType predatorType) {
        return switch (predatorType){
            case WOLF -> animalCharacteristicsDto.getWolf().getBaseFoodNeeded();
            case BOA -> animalCharacteristicsDto.getBoa().getBaseFoodNeeded();
            case FOX -> animalCharacteristicsDto.getFox().getBaseFoodNeeded();
            case BEAR -> animalCharacteristicsDto.getBear().getBaseFoodNeeded();
            case EAGLE -> animalCharacteristicsDto.getEagle().getBaseFoodNeeded();
        };
    }

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

    public double getbaseFoodNeededForOmnivores(OmnivoreType omnivoreType) {
        return switch (omnivoreType){
            case RABBIT -> animalCharacteristicsDto.getRabbit().getBaseFoodNeeded();
            case GOAT -> animalCharacteristicsDto.getGoat().getBaseFoodNeeded();
            case BOAR -> animalCharacteristicsDto.getBoar().getBaseFoodNeeded();
            case DUCK -> animalCharacteristicsDto.getDuck().getBaseFoodNeeded();
        };
    }



}
