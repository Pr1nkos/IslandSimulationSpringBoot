package ru.pr1nkos.islandsimulation.jobs;

import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.services.AnimalMovementService;
import ru.pr1nkos.islandsimulation.services.PlantEatingService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlantEatingJob implements Job {
    private final AnimalMovementService animalMovementService;
    private final PlantEatingService plantEatingService;

    @Override
    public void execute(JobExecutionContext context) {
        animalMovementService.moveAnimals();

        List<Animal> animals = plantEatingService.getAnimalsToFeed();

        animals.forEach(plantEatingService::attemptToEatPlant);
    }
}
