package ru.pr1nkos.islandsimulation.entities.animals.herbivores;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultReproducingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.HerbivoreEatingBehavior;

@EqualsAndHashCode(callSuper = true)
@Data

public class Deer extends Animal {

    private Long id;

    public Deer() {
        super(300, 20, 4, 50,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }

}