package ru.pr1nkos.islandsimulation.entities.island;

import lombok.Data;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Cell.
 */
@Data
public class Cell {
    private List<Animal> animals;
    private List<Plant> plants;

    /**
     * Instantiates a new Cell.
     */
    public Cell() {
        this.animals = new ArrayList<>();
        this.plants = new ArrayList<>();
    }

    /**
     * Add animal.
     *
     * @param animal the animal
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * Remove animal.
     *
     * @param animal the animal
     */
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
}
