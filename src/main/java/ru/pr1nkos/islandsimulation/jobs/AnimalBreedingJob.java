package ru.pr1nkos.islandsimulation.jobs;

import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.services.AnimalBreedingService;

@Component
@RequiredArgsConstructor
public class AnimalBreedingJob implements Job {

    private final AnimalBreedingService animalBreedingService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        animalBreedingService.breedAnimals();
    }
}