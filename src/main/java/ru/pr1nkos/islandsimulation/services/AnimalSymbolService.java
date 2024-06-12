package ru.pr1nkos.islandsimulation.services;

import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.herbivores.*;
import ru.pr1nkos.islandsimulation.entities.animals.predators.*;

@Service
public class AnimalSymbolService {

    public String getAnimalSymbol(Animal animal) {
        if (animal instanceof Bear) {
            return "🐻";
        } else if (animal instanceof Boa) {
            return "🐍";
        } else if (animal instanceof Eagle) {
            return "🦅";
        } else if (animal instanceof Fox) {
            return "🦊";
        } else if (animal instanceof Wolf) {
            return "🐺";
        } else if (animal instanceof Boar) {
            return "🐗";
        } else if (animal instanceof Buffalo) {
            return "🐃";
        } else if (animal instanceof Caterpillar) {
            return "🐛";
        } else if (animal instanceof Deer) {
            return "🦌";
        } else if (animal instanceof Duck) {
            return "🦆";
        } else if (animal instanceof Goat) {
            return "🐐";
        } else if (animal instanceof Horse) {
            return "🐎";
        } else if (animal instanceof Mouse) {
            return "🐁";
        } else if (animal instanceof Rabbit) {
            return "🐇";
        } else if (animal instanceof Sheep) {
            return "🐑";
        }
        return "?";
    }
}
