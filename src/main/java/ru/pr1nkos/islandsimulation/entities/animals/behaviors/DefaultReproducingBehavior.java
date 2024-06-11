package ru.pr1nkos.islandsimulation.entities.animals.behaviors;


import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;

public class DefaultReproducingBehavior implements ReproducingBehavior {
    @Override
    public void reproduce() {
        System.out.println("Животное размножается");
    }
}
