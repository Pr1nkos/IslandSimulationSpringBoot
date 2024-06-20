package ru.pr1nkos.islandsimulation.jobs;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;
import ru.pr1nkos.islandsimulation.services.AnimalManagementService;
import ru.pr1nkos.islandsimulation.services.RandomManager;

@Component
@RequiredArgsConstructor
public class PopulateIslandJob implements Job {

    private final AnimalManagementService animalManagementService;
    private final RandomManager randomManager;

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext context) {
        int animalType = randomManager.nextInt(3);
        switch (animalType) {
            case 0 -> {
                PredatorType[] predatorTypes = PredatorType.values();
                animalManagementService.addPredator
                        (predatorTypes[randomManager.nextInt(predatorTypes.length)]);
            }
            case 1 -> {
                HerbivoreType[] herbivoreTypes = HerbivoreType.values();
                animalManagementService.addHerbivore
                        (herbivoreTypes[randomManager.nextInt(herbivoreTypes.length)]);
            }
            case 2 -> {
                OmnivoreType[] omnivoreTypes = OmnivoreType.values();
                animalManagementService.addOmnivores
                        (omnivoreTypes[randomManager.nextInt(omnivoreTypes.length)]);
            }
            default -> throw new IllegalArgumentException("Unknown animal type");
        }
    }
}
