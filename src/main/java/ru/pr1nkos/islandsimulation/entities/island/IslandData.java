package ru.pr1nkos.islandsimulation.entities.island;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.config.IslandConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Data
@RequiredArgsConstructor
public class IslandData {

    private final IslandConfig islandConfig;
    private final ApplicationEventPublisher eventPublisher;
    private final Map<String, Cell> islandCells = new HashMap<>();

    @PostConstruct
    private void initializeIsland() {
        int width = islandConfig.getWidth();
        int height = islandConfig.getHeight();

        try (ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int finalI = i;
                    int finalJ = j;
                    executor.submit(() -> {
                        String key = finalI + "," + finalJ;
                        synchronized (islandCells) {
                            islandCells.put(key, new Cell());
                        }
                    });
                }
            }
            executor.shutdown();
        }
    }
}