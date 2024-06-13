package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.config.IslandConfig;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IslandInformationService {

    private final IslandData islandData;
    private final AnimalSymbolService animalSymbolService;
    private final IslandConfig islandConfig;
    private final String[][] island;

    public String[][] getIsland() {
        Map<String, List<Animal>> islandMap = islandData.getIslandMap();

        for (int i = 0; i < islandConfig.getWidth(); i++) {
            for (int j = 0; j < islandConfig.getHeight(); j++) {
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
}
