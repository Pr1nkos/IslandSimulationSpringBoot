package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;
import ru.pr1nkos.islandsimulation.entities.island.Cell;
import ru.pr1nkos.islandsimulation.entities.island.IslandData;

import java.util.List;
import java.util.Map;

/**
 * The type Animal breeding service.
 */
@Service
@RequiredArgsConstructor
public class AnimalBreedingService {

    private final AnimalManagementService animalManagementService;
    private final IslandData islandData;
    private final RandomManager randomManager;

    /**
     * Reproduce animals.
     */
    public void reproduceAnimals() {
        Map<String, Cell> islandCells = islandData.getIslandCells();
        List<Cell> cells = List.copyOf(islandCells.values());

        Cell randomCell = randomManager.getRandomElement(cells);
        if (randomCell == null || randomCell.getAnimals().size() < 2) {
            return;
        }

        List<Animal> animals = randomCell.getAnimals();

        int index1 = randomManager.nextInt(animals.size());
        int index2 = randomManager.nextIntExcluding(animals.size(), index1);

        Animal animal1 = animals.get(index1);
        Animal animal2 = animals.get(index2);
        if (animal1.getClass() == animal2.getClass() && randomManager.nextDouble() < 0.5) {

            AnimalType animalType = animal1.getAnimalType();
            Animal newAnimal = animalManagementService.createAnimal(animalType);
            randomCell.addAnimal(newAnimal);
            System.out.println("New animal of type " + animalType.getType() + " has been born in cell." + animal1.getX() + " " + animal1.getY());
        }

    }
}
