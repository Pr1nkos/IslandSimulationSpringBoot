package ru.pr1nkos.islandsimulation.jobs;

import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.services.AnimalMovementService;


@Component
@RequiredArgsConstructor
public class AnimalMovementJob implements Job {

    private final AnimalMovementService animalMovementService;

    @Override
    public void execute(JobExecutionContext context) {
        animalMovementService.moveAnimals();
    }
}
