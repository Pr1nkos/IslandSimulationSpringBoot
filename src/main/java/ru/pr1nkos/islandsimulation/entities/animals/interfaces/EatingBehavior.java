package ru.pr1nkos.islandsimulation.entities.animals.interfaces;

import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;

public interface EatingBehavior {
    void eat(Animal predator, Animal prey);
    void eatPlant(Animal herbivore, Plant plant);
}
