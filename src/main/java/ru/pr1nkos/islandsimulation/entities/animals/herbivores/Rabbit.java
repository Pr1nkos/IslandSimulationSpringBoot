package ru.pr1nkos.islandsimulation.entities.animals.herbivores;



import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultReproducingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.HerbivoreEatingBehavior;

@EqualsAndHashCode(callSuper = true)
@Data

public class Rabbit extends Animal {


    private Long id;

    public Rabbit() {
        super(2, 150, 2, 0.45,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }

}