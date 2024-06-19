package ru.pr1nkos.islandsimulation.entities.animals.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.*;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BehaviorFactory {

    private final ApplicationContext applicationContext;
    private final Map<String, EatingBehavior> eatingBehaviorMap = new HashMap<>();
    private final Map<String, MovingBehavior> movingBehaviorMap = new HashMap<>();
    private final Map<String, ReproducingBehavior> reproducingBehaviorMap = new HashMap<>();
    private final Map<String, PlantEatingBehavior> plantEatingBehaviorMap = new HashMap<>();
    private final Map<String, OmnivoresEatingBehavior> omnivoresEatingBehaviorMap = new HashMap<>();

    public EatingBehavior getEatingBehavior(String type) {
        return eatingBehaviorMap.computeIfAbsent(type, k -> applicationContext.getBean(PredatorEatingBehavior.class));
    }

    public MovingBehavior getMovingBehavior(String type) {
        return movingBehaviorMap.computeIfAbsent(type, k -> applicationContext.getBean(DefaultMovingBehavior.class));
    }

    public ReproducingBehavior getReproducingBehavior(String type) {
        return reproducingBehaviorMap.computeIfAbsent(type, k -> applicationContext.getBean(DefaultReproducingBehavior.class));
    }

    public PlantEatingBehavior getPlantEatingBehavior(String type) {
        return plantEatingBehaviorMap.computeIfAbsent(type, k -> applicationContext.getBean(PlantEatingBehavior.class));
    }

    public OmnivoresEatingBehavior getOmnivoresEatingBehavior(String type) {
        return omnivoresEatingBehaviorMap.computeIfAbsent(type, k -> applicationContext.getBean(OmnivoresEatingBehavior.class));
    }
}
