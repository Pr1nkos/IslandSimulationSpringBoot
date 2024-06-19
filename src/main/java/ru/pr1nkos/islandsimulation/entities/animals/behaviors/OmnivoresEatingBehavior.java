package ru.pr1nkos.islandsimulation.entities.animals.behaviors;

import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;

import java.math.BigDecimal;

@Component
public class OmnivoresEatingBehavior implements EatingBehavior {

    @Override
    public void eat(Animal predator, Animal prey) {
        if (prey.isAlive()) {
            prey.setAlive(false);
            predator.setWeight(predator.getWeight().add(prey.getWeight()));
            System.out.println(predator.getClass().getSimpleName() + " съел " + prey.getClass().getSimpleName());
        } else {
            System.out.println(prey.getClass().getSimpleName() + " уже мертв.");
        }
    }

    @Override
    public void eatPlant(Animal herbivore, Plant plant) {

        plant.setAlive(false);
        herbivore.setWeight(herbivore.getWeight().add(BigDecimal.valueOf(0.5))); // Увеличение веса травоядного
        System.out.println(herbivore.getClass().getSimpleName() + " поел растение");
    }


}
