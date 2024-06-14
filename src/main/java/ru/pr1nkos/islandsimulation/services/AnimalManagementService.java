package ru.pr1nkos.islandsimulation.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.config.IslandConfig;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.factory.AnimalFactory;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@Data
@RequiredArgsConstructor
public class AnimalManagementService {

    private final AnimalFactory animalFactory;
    private final List<Animal> animals = new ArrayList<>();
    private final Random random = new Random();
    private final IslandData islandData;
    private final IslandConfig islandConfig;

    public void addPredator(PredatorType predatorType) {
        Animal animal = animalFactory.createAnimal(predatorType);
        animals.add(animal);
        placeAnimalOnIsland(animal);
    }

    public void addHerbivore(HerbivoreType herbivoreType) {
        Animal animal = animalFactory.createAnimal(herbivoreType);
        animals.add(animal);
        placeAnimalOnIsland(animal);
    }

    private void placeAnimalOnIsland(Animal animal) {
        Map<String, List<Animal>> islandMap = islandData.getIslandMap();
        int x, y;
        do {
            x = random.nextInt(islandConfig.getWidth());
            y = random.nextInt(islandConfig.getHeight());
        } while (!canPlaceAnimal(x, y, islandMap));

        animal.setX(x);
        animal.setY(y);
        String key = x + "," + y;
        islandMap.computeIfAbsent(key, k -> new ArrayList<>()).add(animal);
    }

    private boolean canPlaceAnimal(int x, int y, Map<String, List<Animal>> islandMap) {
        String key = x + "," + y;
        List<Animal> presentedAnimals = islandMap.getOrDefault(key, new ArrayList<>());
        return presentedAnimals.size() < 10;
    }

    public List<Animal> getAnimalsAt(int x, int y) {
        String key = x + "," + y;
        return islandData.getIslandMap().getOrDefault(key, new ArrayList<>());
    }

    public void removeAnimalFromIsland(Animal animal) {
        String key = animal.getX() + "," + animal.getY();
        islandData.getIslandMap().get(key).remove(animal);
        animals.remove(animal);
    }
}
