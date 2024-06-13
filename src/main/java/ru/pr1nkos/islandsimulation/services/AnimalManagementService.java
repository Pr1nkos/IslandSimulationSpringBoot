package ru.pr1nkos.islandsimulation.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
            x = random.nextInt(100);
            y = random.nextInt(20);
        } while (!canPlaceAnimal(x, y, islandMap));

        String key = x + "," + y;
        islandMap.get(key).add(animal);
    }
    private boolean canPlaceAnimal(int x, int y, Map<String, List<Animal>> islandMap) {
        String key = x + "," + y;
        List<Animal> animals = islandMap.getOrDefault(key, new ArrayList<>());
        return animals.size() < 10;
    }
}
