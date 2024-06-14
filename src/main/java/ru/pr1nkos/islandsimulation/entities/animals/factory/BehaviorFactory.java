package ru.pr1nkos.islandsimulation.entities.animals.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultEatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultReproducingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BehaviorFactory {

    private final Map<String, EatingBehavior> eatingBehaviorMap = new HashMap<>();
    private final Map<String, MovingBehavior> movingBehaviorMap = new HashMap<>();
    private final Map<String, ReproducingBehavior> reproducingBehaviorMap = new HashMap<>();

    public EatingBehavior getEatingBehavior(String type) {
        return eatingBehaviorMap.computeIfAbsent(type, k -> new DefaultEatingBehavior());
    }

    public MovingBehavior getMovingBehavior(String type) {
        return movingBehaviorMap.computeIfAbsent(type, k -> new DefaultMovingBehavior());
    }

    public ReproducingBehavior getReproducingBehavior(String type) {
        return reproducingBehaviorMap.computeIfAbsent(type, k -> new DefaultReproducingBehavior());
    }
}
