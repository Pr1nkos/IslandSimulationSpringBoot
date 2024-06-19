package ru.pr1nkos.islandsimulation.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pr1nkos.islandsimulation.jobs.AnimalEatingJob;
import ru.pr1nkos.islandsimulation.jobs.AnimalMovementJob;
import ru.pr1nkos.islandsimulation.jobs.PlantAppearJob;
import ru.pr1nkos.islandsimulation.jobs.PlantEatingJob;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail animalMovementJobDetail() {
        return JobBuilder.newJob(AnimalMovementJob.class)
                .withIdentity("animalMovementJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger animalMovementJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(animalMovementJobDetail())
                .withIdentity("animalMovementTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail animalEatingJobDetail() {
        return JobBuilder.newJob(AnimalEatingJob.class)
                .withIdentity("animalEatingJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger animalEatingJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(animalEatingJobDetail())
                .withIdentity("animalEatingTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail plantAppearJobDetail() {
        return JobBuilder.newJob(PlantAppearJob.class)
                .withIdentity("plantAppearJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger plantAppearJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(plantAppearJobDetail())
                .withIdentity("plantAppearTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail plantEatingJobDetail() {
        return JobBuilder.newJob(PlantEatingJob.class)
                .withIdentity("plantEatingJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger plantEatingJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10) // Пример: раз в 15 секунд
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(plantEatingJobDetail())
                .withIdentity("plantEatingTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}

