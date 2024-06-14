package ru.pr1nkos.islandsimulation.pojo;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.config.IslandConfig;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
@RequiredArgsConstructor
public class IslandData {

    private final IslandConfig islandConfig;
    private Map<String, List<Animal>> islandMap;

    @PostConstruct
    private void initializeIsland() {
        this.islandMap = new HashMap<>();
        int width = islandConfig.getWidth();
        int height = islandConfig.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                String key = i + "," + j;
                islandMap.put(key, new ArrayList<>());
            }
        }
    }
}
