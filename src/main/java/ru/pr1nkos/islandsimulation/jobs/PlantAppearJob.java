package ru.pr1nkos.islandsimulation.jobs;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.services.PlantManagementService;

/**
 * The type Plant appear job.
 */
@Component
@RequiredArgsConstructor
public class PlantAppearJob implements Job {

    private final PlantManagementService plantManagementService;

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext context) {
        plantManagementService.addPlant();
    }
}
