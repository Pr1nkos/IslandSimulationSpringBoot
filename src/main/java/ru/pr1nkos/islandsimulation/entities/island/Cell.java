package ru.pr1nkos.islandsimulation.entities.island;

import lombok.Data;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cell {
    private List<Animal> animals;
    private List<Plant> plants;

    public Cell() {
        this.animals = new ArrayList<>();
        this.plants = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
}
