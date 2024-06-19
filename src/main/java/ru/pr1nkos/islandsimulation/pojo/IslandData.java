package ru.pr1nkos.islandsimulation.pojo;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.config.IslandConfig;

import java.util.HashMap;
import java.util.Map;

@Component
@Data
@RequiredArgsConstructor
public class IslandData {

    private final IslandConfig islandConfig;
    private final ApplicationEventPublisher eventPublisher;
    private Map<String, Cell> islandCells;

    @PostConstruct
    private void initializeIsland() {
        this.islandCells = new HashMap<>();
        int width = islandConfig.getWidth();
        int height = islandConfig.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                String key = i + "," + j;
                islandCells.put(key, new Cell());
            }
        }

    }
}