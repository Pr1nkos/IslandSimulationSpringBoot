package ru.pr1nkos.islandsimulation.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
