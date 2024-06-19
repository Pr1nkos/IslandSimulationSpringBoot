package ru.pr1nkos.islandsimulation;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.pojo.Cell;
import ru.pr1nkos.islandsimulation.services.AnimalManagementService;

@Component
@RequiredArgsConstructor
public class AnimalPopulationRunner implements CommandLineRunner {

    private final AnimalManagementService animalManagementService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Cell cell = new Cell();
            animalManagementService.addRandomAnimal(cell);
        }
    }
}
