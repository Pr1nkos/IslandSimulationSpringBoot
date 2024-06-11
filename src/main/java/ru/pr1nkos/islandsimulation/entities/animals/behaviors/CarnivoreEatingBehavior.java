package ru.pr1nkos.islandsimulation.entities.animals.behaviors;


import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;

public class CarnivoreEatingBehavior implements EatingBehavior {
    @Override
    public void eat(Animal predator, Animal prey) {
        System.out.println(predator.getClass().getSimpleName() + " съедает" + prey.getClass().getSimpleName());
    }
}