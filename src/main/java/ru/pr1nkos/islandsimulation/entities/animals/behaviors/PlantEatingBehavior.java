package ru.pr1nkos.islandsimulation.entities.animals.behaviors;

import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;

@Component
public class PlantEatingBehavior implements EatingBehavior {

    @Override
    public void eat(Animal predator, Animal prey) {
        // Для этой реализации не нужен метод eat(Animal predator, Animal prey)
        System.out.println("Этот метод не используется для PlantEatingBehavior");
    }

    @Override
    public void eatPlant(Animal herbivore, Plant plant) {
        plant.setAlive(false);
        System.out.println(herbivore.getClass().getSimpleName() + " съел растение");
    }
}
