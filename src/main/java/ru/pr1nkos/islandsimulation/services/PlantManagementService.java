package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;
import ru.pr1nkos.islandsimulation.pojo.Cell;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PlantManagementService {

    private final List<Plant> plants = new ArrayList<>();
    private final Random random = new Random();
    private final IslandData islandData;

    public void addPlant() {
        Plant plant = new Plant();
        plants.add(plant);
        placePlantOnIsland(plant);
    }

    private void placePlantOnIsland(Plant plant) {
        Map<String, Cell> islandCells = islandData.getIslandCells();
        int x, y;
        do {
            x = random.nextInt(islandData.getIslandConfig().getWidth());
            y = random.nextInt(islandData.getIslandConfig().getHeight());
        } while (!canPlacePlant(x, y, islandCells));

        plant.setX(x);
        plant.setY(y);
        String key = x + "," + y;
        islandCells.computeIfAbsent(key, k -> new Cell()).getPlants().add(plant);
    }

    private boolean canPlacePlant(int x, int y, Map<String, Cell> islandCells) {
        String key = x + "," + y;
        Cell cell = islandCells.getOrDefault(key, new Cell());
        return cell.getPlants().size() < 200;
    }

    public List<Plant> getPlantsAt(int x, int y) {
        String key = x + "," + y;
        return islandData.getIslandCells().getOrDefault(key, new Cell()).getPlants();
    }

    public void removePlantFromIsland(Plant plant) {
        String key = plant.getX() + "," + plant.getY();
        islandData.getIslandCells().get(key).getPlants().remove(plant);
        plants.remove(plant);
    }
}
