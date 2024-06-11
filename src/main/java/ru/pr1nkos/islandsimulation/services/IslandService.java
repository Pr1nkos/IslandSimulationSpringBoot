package ru.pr1nkos.islandsimulation.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.factory.AnimalFactory;
import ru.pr1nkos.islandsimulation.entities.animals.herbivores.*;
import ru.pr1nkos.islandsimulation.entities.animals.predators.*;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;

import java.util.Arrays;
import java.util.Random;

@Data
@Service
public class IslandService {

    private final AnimalFactory animalFactory;
    private final AnimalService animalService;
    private final String[][] island;
    private final Random random = new Random();

    public IslandService(AnimalFactory animalFactory, AnimalService animalService) {
        this.animalFactory = animalFactory;
        this.animalService = animalService;
        this.island = new String[100][20]; // Assuming the island is 100x20
        initializeIsland();
    }

    private void initializeIsland() {
        for (String[] strings : island) {
            Arrays.fill(strings, ".");
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
            x = random.nextInt(island.length);
            y = random.nextInt(island[0].length);
        } while (!island[x][y].equals("."));

        String animalSymbol = getAnimalSymbol(animal);
        island[x][y] = animalSymbol;
    }

    private String getAnimalSymbol(Animal animal) {
        if (animal instanceof Bear) {
            return "🐻";
        } else if (animal instanceof Boa) {
            return "🐍";
        } else if (animal instanceof Eagle) {
            return "🦅";
        } else if (animal instanceof Fox) {
            return "🦊";
        } else if (animal instanceof Wolf) {
            return "🐺";
        } else if (animal instanceof Boar) {
            return "🐗";
        } else if (animal instanceof Buffalo) {
            return "🐃";
        } else if (animal instanceof Caterpillar) {
            return "🐛";
        } else if (animal instanceof Deer) {
            return "🦌";
        } else if (animal instanceof Duck) {
            return "🦆";
        } else if (animal instanceof Goat) {
            return "🐐";
        }else if (animal instanceof Horse) {
            return "🐎";
        }else if (animal instanceof Mouse) {
            return "🐁";
        }else if (animal instanceof Rabbit) {
            return "🐇";
        }else if (animal instanceof Sheep) {
            return "🐑";
        }
        return "?";
    }
}
