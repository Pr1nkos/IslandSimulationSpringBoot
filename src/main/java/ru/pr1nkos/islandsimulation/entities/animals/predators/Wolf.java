package ru.pr1nkos.islandsimulation.entities.animals.predators;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.CarnivoreEatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultReproducingBehavior;

@EqualsAndHashCode(callSuper = true)
@Data

public class Wolf extends Animal {
    private Long id;

    public Wolf() {
        super(50, 30, 3, 8,
                new CarnivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }

}