package ru.pr1nkos.islandsimulation.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.factory.AnimalFactory;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;
import ru.pr1nkos.islandsimulation.entities.island.Cell;
import ru.pr1nkos.islandsimulation.entities.island.IslandData;

import java.util.List;
import java.util.Map;

/**
 * The type Animal management service.
 */
@Service
@Data
@RequiredArgsConstructor
public class AnimalManagementService {

    private final AnimalFactory animalFactory;
    private final RandomManager randomManager;
    private final IslandData islandData;

    /**
     * Add predator.
     *
     * @param predatorType the predator type
     */
    public void addPredator(PredatorType predatorType) {
        Animal animal = animalFactory.createAnimal(predatorType);
        placeAnimalOnIsland(animal);
    }

    /**
     * Add herbivore.
     *
     * @param herbivoreType the herbivore type
     */
    public void addHerbivore(HerbivoreType herbivoreType) {
        Animal animal = animalFactory.createAnimal(herbivoreType);
        placeAnimalOnIsland(animal);
    }

    /**
     * Add omnivores.
     *
     * @param omnivoreType the omnivore type
     */
    public void addOmnivores(OmnivoreType omnivoreType) {
        Animal animal = animalFactory.createAnimal(omnivoreType);
        placeAnimalOnIsland(animal);
    }

    /**
     * Create animal animal.
     *
     * @param animalType the animal type
     * @return the animal
     */
    public Animal createAnimal(AnimalType animalType) {
        return switch (animalType) {
            case PredatorType predatorType -> animalFactory.createAnimal(predatorType);
            case HerbivoreType herbivoreType -> animalFactory.createAnimal(herbivoreType);
            case OmnivoreType omnivoreType -> animalFactory.createAnimal(omnivoreType);
            case null, default -> throw new IllegalArgumentException("Unknown animal type: " + animalType);
        };
    }

    private void placeAnimalOnIsland(Animal animal) {
        Map<String, Cell> islandCells = islandData.getIslandCells();
        int x, y;
        do {
            x = randomManager.nextInt(islandData.getIslandConfig().getWidth());
            y = randomManager.nextInt(islandData.getIslandConfig().getHeight());
        } while (!canPlaceAnimal(x, y, islandCells, animal));

        animal.setX(x);
        animal.setY(y);
        String key = x + "," + y;
        islandCells.computeIfAbsent(key, k -> new Cell()).addAnimal(animal);
    }

    private boolean canPlaceAnimal(int x, int y, Map<String, Cell> islandCells, Animal animal) {
        String key = x + "," + y;
        Cell cell = islandCells.getOrDefault(key, new Cell());
        return cell.getAnimals().size() < animal.getBaseMaxCountPerLocation();
    }

    /**
     * Gets animals at.
     *
     * @param x the x
     * @param y the y
     * @return the animals at
     */
    public List<Animal> getAnimalsAt(int x, int y) {
        String key = x + "," + y;
        return islandData.getIslandCells().getOrDefault(key, new Cell()).getAnimals();
    }

    /**
     * Remove animal from island.
     *
     * @param animal the animal
     */
    public void removeAnimalFromIsland(Animal animal) {
        String key = animal.getX() + "," + animal.getY();
        islandData.getIslandCells().get(key).removeAnimal(animal);
    }
}
