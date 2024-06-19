package ru.pr1nkos.islandsimulation.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.factory.AnimalFactory;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;
import ru.pr1nkos.islandsimulation.pojo.Cell;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@Data
@RequiredArgsConstructor
public class AnimalManagementService {

    private final AnimalFactory animalFactory;
    private final Random random = new Random();
    private final IslandData islandData;

    public void addPredator(PredatorType predatorType) {
        Animal animal = animalFactory.createAnimal(predatorType);
        placeAnimalOnIsland(animal);
    }

    public void addHerbivore(HerbivoreType herbivoreType) {
        Animal animal = animalFactory.createAnimal(herbivoreType);
        placeAnimalOnIsland(animal);
    }

    public void addOmnivores(OmnivoreType omnivoreType) {
        Animal animal = animalFactory.createAnimal(omnivoreType);
        placeAnimalOnIsland(animal);
    }

    private void placeAnimalOnIsland(Animal animal) {
        Map<String, Cell> islandCells = islandData.getIslandCells();
        int x, y;
        do {
            x = random.nextInt(islandData.getIslandConfig().getWidth());
            y = random.nextInt(islandData.getIslandConfig().getHeight());
        } while (!canPlaceAnimal(x, y, islandCells));

        animal.setX(x);
        animal.setY(y);
        String key = x + "," + y;
        islandCells.computeIfAbsent(key, k -> new Cell()).addAnimal(animal);
    }

    private boolean canPlaceAnimal(int x, int y, Map<String, Cell> islandCells) {
        String key = x + "," + y;
        Cell cell = islandCells.getOrDefault(key, new Cell());
        return cell.getAnimals().size() < 10;
    }

    public List<Animal> getAnimalsAt(int x, int y) {
        String key = x + "," + y;
        return islandData.getIslandCells().getOrDefault(key, new Cell()).getAnimals();
    }

    public void removeAnimalFromIsland(Animal animal) {
        String key = animal.getX() + "," + animal.getY();
        islandData.getIslandCells().get(key).removeAnimal(animal);
    }
}
