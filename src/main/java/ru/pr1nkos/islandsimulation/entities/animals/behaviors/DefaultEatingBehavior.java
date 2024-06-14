package ru.pr1nkos.islandsimulation.entities.animals.behaviors;

import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;

@Component
public class DefaultEatingBehavior implements EatingBehavior {

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
}
