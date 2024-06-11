package ru.pr1nkos.islandsimulation.entities.animals.behaviors;


import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;

public class DefaultMovingBehavior implements MovingBehavior {
    @Override
    public void move() {
        System.out.println("Животное двигается");
    }
}
