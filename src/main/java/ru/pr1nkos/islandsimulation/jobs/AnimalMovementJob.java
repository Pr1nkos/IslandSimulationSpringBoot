package ru.pr1nkos.islandsimulation.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.services.AnimalMovementService;

@Component
public class AnimalMovementJob implements Job {

    @Autowired
    private AnimalMovementService animalMovementService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        animalMovementService.moveAnimals();
    }
}
