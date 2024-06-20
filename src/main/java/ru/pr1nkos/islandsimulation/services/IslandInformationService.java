package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.config.IslandConfig;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.island.Cell;
import ru.pr1nkos.islandsimulation.entities.island.IslandData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IslandInformationService {

    private final IslandData islandData;
    private final AnimalSymbolService animalSymbolService;
    private final IslandConfig islandConfig;

    public String[][] getIsland() {
        String[][] island = new String[islandConfig.getWidth()][islandConfig.getHeight()];
        Map<String, Cell> islandCells = islandData.getIslandCells();

        for (int i = 0; i < islandConfig.getWidth(); i++) {
            for (int j = 0; j < islandConfig.getHeight(); j++) {
                String key = i + "," + j;
                Cell cell = islandCells.getOrDefault(key, new Cell());
                island[i][j] = getCellRepresentation(cell);
            }
        }
        return island;
    }

    private String getCellRepresentation(Cell cell) {
        int totalEntities = cell.getAnimals().size() + cell.getPlants().size();
        return totalEntities > 0 ? String.valueOf(totalEntities) : "";
    }

    public List<String> getAnimalSymbolsInCell(int x, int y) {
        String key = x + "," + y;
        Cell cell = islandData.getIslandCells().getOrDefault(key, new Cell());
        List<String> symbols = new ArrayList<>();
        for (Animal animal : cell.getAnimals()) {
            symbols.add(animalSymbolService.getAnimalSymbol(animal));
        }

        cell.getPlants().forEach(plant -> symbols.add("🌿"));

        return symbols;
    }
}
