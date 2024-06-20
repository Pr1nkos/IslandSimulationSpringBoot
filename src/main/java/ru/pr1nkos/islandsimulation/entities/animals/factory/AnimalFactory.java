package ru.pr1nkos.islandsimulation.entities.animals.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;

@Component
@RequiredArgsConstructor
public class AnimalFactory {

    private final AnimalFlyweightFactory animalFlyweightFactory;

    public Animal createAnimal(PredatorType predatorType) {
        return animalFlyweightFactory.getAnimal(predatorType);
    }

    public Animal createAnimal(HerbivoreType herbivoreType) {
        return animalFlyweightFactory.getAnimal(herbivoreType);
    }

    public Animal createAnimal(OmnivoreType omnivoreType) {
        return animalFlyweightFactory.getAnimal(omnivoreType);
    }

}
