package ru.pr1nkos.islandsimulation.jobs;

import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.services.PlantManagementService;

@Component
@RequiredArgsConstructor
public class PlantAppearJob implements Job {

    private final PlantManagementService plantManagementService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        plantManagementService.addPlant();
    }
}
