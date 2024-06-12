package ru.pr1nkos.islandsimulation.entities.animals.behaviors;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class CarnivoreEatingBehavior implements EatingBehavior {
    @Override
    public void eat(Animal predator, Animal prey) {
        System.out.println(predator.getClass().getSimpleName() + " съедает" + prey.getClass().getSimpleName());
    }
}
