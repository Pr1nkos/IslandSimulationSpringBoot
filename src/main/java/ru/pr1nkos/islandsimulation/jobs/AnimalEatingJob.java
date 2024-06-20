package ru.pr1nkos.islandsimulation.jobs;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.services.AnimalEatingService;
import ru.pr1nkos.islandsimulation.services.AnimalMovementService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnimalEatingJob implements Job {
    private final AnimalMovementService animalMovementService;
    private final AnimalEatingService animalEatingService;

    @Override
    public void execute(JobExecutionContext context) {

        List<Animal> animals = animalEatingService.getAnimalsToFeed();

        animals.forEach(animalEatingService::attemptToEat);
    }
}
