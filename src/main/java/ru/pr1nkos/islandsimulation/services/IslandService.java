package ru.pr1nkos.islandsimulation.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.factory.AnimalFactory;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;

import java.util.*;

@Data
@Service
public class IslandService {

    private final AnimalFactory animalFactory;
    private final AnimalService animalService;
    private final Map<String, List<Animal>> islandMap;
    private final Random random = new Random();
    private final AnimalSymbolService animalSymbolService;

    public IslandService(AnimalFactory animalFactory, AnimalService animalService, AnimalSymbolService animalSymbolService) {
        this.animalFactory = animalFactory;
        this.animalService = animalService;
        this.islandMap = new HashMap<>();
        this.animalSymbolService = animalSymbolService;
        initializeIsland();
    }

    private void initializeIsland() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                String key = i + "," + j;
                islandMap.put(key, new ArrayList<>());
            }
        }
    }

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
        int x, y;
        do {
            x = random.nextInt(100);
            y = random.nextInt(20);
        } while (!canPlaceAnimal(x, y));

        String key = x + "," + y;
        islandMap.get(key).add(animal);
    }

    private boolean canPlaceAnimal(int x, int y) {
        String key = x + "," + y;
        List<Animal> animals = islandMap.get(key);
        return animals.size() < 10;
    }

    public String[][] getIsland() {
        String[][] island = new String[100][20];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                String key = i + "," + j;
                List<Animal> animals = islandMap.get(key);
                island[i][j] = animals.isEmpty() ? "" : animals.size() + "";
            }
        }
        return island;
    }

    public List<String> getAnimalSymbolsInCell(int x, int y) {
        String key = x + "," + y;
        List<Animal> animals = islandMap.get(key);
        List<String> symbols = new ArrayList<>();
        for (Animal animal : animals) {
            symbols.add(animalSymbolService.getAnimalSymbol(animal));
        }
        return symbols;
    }

}
