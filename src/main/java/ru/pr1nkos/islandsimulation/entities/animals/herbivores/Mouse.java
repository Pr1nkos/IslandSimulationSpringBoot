package ru.pr1nkos.islandsimulation.entities.animals.herbivores;



import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultReproducingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.HerbivoreEatingBehavior;

@EqualsAndHashCode(callSuper = true)
@Data

public class Mouse extends Animal {



    public Mouse() {
        super(0.05, 500, 1, 0.01,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }

}