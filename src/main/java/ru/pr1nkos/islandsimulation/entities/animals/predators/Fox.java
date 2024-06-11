package ru.pr1nkos.islandsimulation.entities.animals.predators;



import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.CarnivoreEatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultReproducingBehavior;

@EqualsAndHashCode(callSuper = true)
@Data

public class Fox extends Animal {

    private Long id;
    public Fox() {
        super(8, 30, 2, 2,
                new CarnivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}
