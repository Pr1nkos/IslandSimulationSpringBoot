package ru.pr1nkos.islandsimulation.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pr1nkos.islandsimulation.jobs.AnimalEatingJob;
import ru.pr1nkos.islandsimulation.jobs.AnimalMovementJob;

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
                .withIntervalInSeconds(5) // Укажите интервал в секундах
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
                .withIntervalInSeconds(10) // Интервал в секундах между выполнениями job
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(animalEatingJobDetail())
                .withIdentity("animalEatingTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
