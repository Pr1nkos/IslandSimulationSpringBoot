package ru.pr1nkos.islandsimulation.entities.animals.behaviors;

import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;

@Component
public class OmnivoresEatingBehavior implements EatingBehavior {

    @Override
    public void eat(Animal predator, Animal prey) {
        if (prey.isAlive()) {
            prey.setAlive(false);
            System.out.println(predator.getClass().getSimpleName() + " съел " + prey.getClass().getSimpleName());
        } else {
            System.out.println(prey.getClass().getSimpleName() + " уже мертв.");
        }
    }

    @Override
    public void eatPlant(Animal herbivore, Plant plant) {

        plant.setAlive(false);
        System.out.println(herbivore.getClass().getSimpleName() + " поел растение");
    }


}
