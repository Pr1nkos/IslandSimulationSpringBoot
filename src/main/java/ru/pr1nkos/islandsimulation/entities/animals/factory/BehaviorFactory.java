package ru.pr1nkos.islandsimulation.entities.animals.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.*;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.*;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BehaviorFactory {

    private final Map<String, EatingBehavior> eatingBehaviorMap = new HashMap<>();
    private final Map<String, MovingBehavior> movingBehaviorMap = new HashMap<>();
    private final Map<String, ReproducingBehavior> reproducingBehaviorMap = new HashMap<>();
    private final Map<String, PlantEatingBehavior> plantEatingBehaviorMap = new HashMap<>(); // Добавляем новую карту для PlantEatingBehavior
    private final Map<String, OmnivoresEatingBehavior> omnivoresEatingBehaviorMap = new HashMap<>(); // Добавляем новую карту для PlantEatingBehavior


    public EatingBehavior getEatingBehavior(String type) {
        return eatingBehaviorMap.computeIfAbsent(type, k -> new PredatorEatingBehavior());
    }

    public MovingBehavior getMovingBehavior(String type) {
        return movingBehaviorMap.computeIfAbsent(type, k -> new DefaultMovingBehavior());
    }

    public ReproducingBehavior getReproducingBehavior(String type) {
        return reproducingBehaviorMap.computeIfAbsent(type, k -> new DefaultReproducingBehavior());
    }

    public PlantEatingBehavior getPlantEatingBehavior(String type) {
        return plantEatingBehaviorMap.computeIfAbsent(type, k -> new PlantEatingBehavior());
    }

    public OmnivoresEatingBehavior getOmnivoresEatingBehavior(String type) {
        return omnivoresEatingBehaviorMap.computeIfAbsent(type, k -> new OmnivoresEatingBehavior());
    }
}
