package ru.pr1nkos.islandsimulation.entities.animals.factory;

import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.herbivores.*;
import ru.pr1nkos.islandsimulation.entities.animals.predators.*;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;

@Component
public class AnimalFactory {
    public Animal createAnimal(PredatorType predatorType) {
        return switch (predatorType) {
            case BEAR -> new Bear();
            case BOA -> new Boa();
            case EAGLE -> new Eagle();
            case FOX -> new Fox();
            case WOLF -> new Wolf();
        };
    }

    public Animal createAnimal(HerbivoreType herbivoreType) {
        return switch (herbivoreType) {
            case BOAR -> new Boar();
            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER -> new Deer();
            case DUCK -> new Duck();
            case GOAT -> new Goat();
            case HORSE -> new Horse();
            case MOUSE -> new Mouse();
            case RABBIT -> new Rabbit();
            case SHEEP -> new Sheep();
        };
    }
}
