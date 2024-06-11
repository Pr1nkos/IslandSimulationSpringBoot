package ru.pr1nkos.islandsimulation.entities.animals.herbivores;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultReproducingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.HerbivoreEatingBehavior;

@EqualsAndHashCode(callSuper = true)
@Data

public class Sheep extends Animal {

    private Long id;

    public Sheep() {
        super(70, 140, 3, 15,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }

}