package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.factory.AnimalFactory;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimalService {
    private final AnimalFactory animalFactory;
    private final List<Animal> animals = new ArrayList<>();

    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals);
    }

    public void addAnimal(PredatorType predatorType) {
        Animal animal = animalFactory.createAnimal(predatorType);
        animals.add(animal);
    }

    public void addAnimal(HerbivoreType herbivoreType) {
        Animal animal = animalFactory.createAnimal(herbivoreType);
        animals.add(animal);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
}
