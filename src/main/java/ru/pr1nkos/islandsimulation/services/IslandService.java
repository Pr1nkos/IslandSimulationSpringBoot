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

@Data
@Service
@RequiredArgsConstructor
public class IslandService {

    private final AnimalFactory animalFactory;
    private final AnimalService animalService;
    private final Random random = new Random();
    private final AnimalSymbolService animalSymbolService;
    private final IslandData islandData;


    public void addPredator(PredatorType predatorType) {
        Animal animal = animalFactory.createAnimal(predatorType);
        animalService.addAnimal(animal);
        placeAnimalOnIsland(animal);
    }

    public void addHerbivore(HerbivoreType herbivoreType) {
        Animal animal = animalFactory.createAnimal(herbivoreType);
        animalService.addAnimal(animal);
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

    public String[][] getIsland() {
        String[][] island = new String[100][20];
        Map<String, List<Animal>> islandMap = islandData.getIslandMap();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                String key = i + "," + j;
                List<Animal> animals = islandMap.getOrDefault(key, new ArrayList<>());
                island[i][j] = animals.isEmpty() ? "" : String.valueOf(animals.size());
            }
        }
        return island;
    }

    public List<String> getAnimalSymbolsInCell(int x, int y) {
        String key = x + "," + y;
        Map<String, List<Animal>> islandMap = islandData.getIslandMap();
        List<Animal> animals = islandMap.getOrDefault(key, new ArrayList<>());
        List<String> symbols = new ArrayList<>();
        for (Animal animal : animals) {
            symbols.add(animalSymbolService.getAnimalSymbol(animal));
        }
        return symbols;
    }

    public void updateIsland() {
        String[][] island = new String[100][20];
        Map<String, List<Animal>> islandMap = islandData.getIslandMap();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                String key = i + "," + j;
                List<Animal> animals = islandMap.getOrDefault(key, new ArrayList<>());
                island[i][j] = animals.isEmpty() ? "" : String.valueOf(animals.size());
            }
        }
    }
}
