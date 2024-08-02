package ru.pr1nkos.islandsimulation.jobs;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.services.AnimalBreedingService;

/**
 * The type Animal breeding job.
 */
@Component
@RequiredArgsConstructor
public class AnimalBreedingJob implements Job {

    private final AnimalBreedingService animalBreedingService;

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext context) {
        animalBreedingService.reproduceAnimals();
    }
}