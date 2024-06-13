package ru.pr1nkos.islandsimulation.pojo;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
@RequiredArgsConstructor
public class IslandData {

    private Map<String, List<Animal>> islandMap;


    @PostConstruct
    private void initializeIsland() {
        this.islandMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                String key = i + "," + j;
                islandMap.put(key, new ArrayList<>());
            }
        }
    }

}
