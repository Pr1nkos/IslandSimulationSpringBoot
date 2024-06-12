package ru.pr1nkos.islandsimulation.entities.animals.interfaces;

import ru.pr1nkos.islandsimulation.entities.animals.Animal;

public interface EatingBehavior {
    void eat(Animal predator, Animal prey);
}

