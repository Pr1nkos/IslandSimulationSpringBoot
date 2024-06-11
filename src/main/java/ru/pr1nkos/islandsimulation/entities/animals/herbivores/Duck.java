package ru.pr1nkos.islandsimulation.entities.animals.herbivores;


import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultMovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.DefaultReproducingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.behaviors.HerbivoreEatingBehavior;

public class Duck extends Animal {
    public Duck() {
        super(1, 200, 4, 0.15,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}
