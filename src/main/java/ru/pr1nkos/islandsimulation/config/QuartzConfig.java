package ru.pr1nkos.islandsimulation.config;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.pr1nkos.islandsimulation.jobs.*;

/**
 * The type Quartz config.
 */
@Configuration
@PropertySource("classpath:application.yml")
public class QuartzConfig {

    @Value("${app.initialAnimalsCount}")
    private int initialAnimalsCount;

    @Value("${app.animalMovementJobIntervalInSeconds}")
    private int animalMovementJobIntervalInSeconds;

    @Value("${app.animalEatingJobIntervalInSeconds}")
    private int animalEatingJobIntervalInSeconds;

    @Value("${app.plantAppearJobIntervalInSeconds}")
    private int plantAppearJobIntervalInSeconds;

    @Value("${app.plantEatingJobIntervalInSeconds}")
    private int plantEatingJobIntervalInSeconds;

    @Value("${app.animalBreedingJobIntervalInSeconds}")
    private int animalBreedingJobIntervalInSeconds;

    @Value("${app.populateIslandJobIntervalInMilliseconds}")
    private int populateIslandJobIntervalInMilliseconds;

    /**
     * Animal movement job detail job detail.
     *
     * @return the job detail
     */
    @Bean
    public JobDetail animalMovementJobDetail() {
        return JobBuilder.newJob(AnimalMovementJob.class)
                .withIdentity("animalMovementJob")
                .storeDurably()
                .build();
    }

    /**
     * Animal movement job trigger trigger.
     *
     * @return the trigger
     */
    @Bean
    public Trigger animalMovementJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(animalMovementJobIntervalInSeconds)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(animalMovementJobDetail())
                .withIdentity("animalMovementTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    /**
     * Animal eating job detail job detail.
     *
     * @return the job detail
     */
    @Bean
    public JobDetail animalEatingJobDetail() {
        return JobBuilder.newJob(AnimalEatingJob.class)
                .withIdentity("animalEatingJob")
                .storeDurably()
                .build();
    }

    /**
     * Animal eating job trigger trigger.
     *
     * @return the trigger
     */
    @Bean
    public Trigger animalEatingJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(animalEatingJobIntervalInSeconds)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(animalEatingJobDetail())
                .withIdentity("animalEatingTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    /**
     * Plant appear job detail job detail.
     *
     * @return the job detail
     */
    @Bean
    public JobDetail plantAppearJobDetail() {
        return JobBuilder.newJob(PlantAppearJob.class)
                .withIdentity("plantAppearJob")
                .storeDurably()
                .build();
    }

    /**
     * Plant appear job trigger trigger.
     *
     * @return the trigger
     */
    @Bean
    public Trigger plantAppearJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(plantAppearJobIntervalInSeconds)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(plantAppearJobDetail())
                .withIdentity("plantAppearTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    /**
     * Plant eating job detail job detail.
     *
     * @return the job detail
     */
    @Bean
    public JobDetail plantEatingJobDetail() {
        return JobBuilder.newJob(PlantEatingJob.class)
                .withIdentity("plantEatingJob")
                .storeDurably()
                .build();
    }

    /**
     * Plant eating job trigger trigger.
     *
     * @return the trigger
     */
    @Bean
    public Trigger plantEatingJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(plantEatingJobIntervalInSeconds)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(plantEatingJobDetail())
                .withIdentity("plantEatingTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    /**
     * Animal breeding job detail job detail.
     *
     * @return the job detail
     */
    @Bean
    public JobDetail animalBreedingJobDetail() {
        return JobBuilder.newJob(AnimalBreedingJob.class)
                .withIdentity("animalBreedingJob")
                .storeDurably()
                .build();
    }

    /**
     * Animal breeding job trigger trigger.
     *
     * @return the trigger
     */
    @Bean
    public Trigger animalBreedingJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(animalBreedingJobIntervalInSeconds)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(animalBreedingJobDetail())
                .withIdentity("animalBreedingTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    /**
     * Populate island job detail job detail.
     *
     * @return the job detail
     */
    @Bean
    public JobDetail populateIslandJobDetail() {
        return JobBuilder.newJob(PopulateIslandJob.class)
                .withIdentity("populateIslandJob")
                .storeDurably()
                .build();
    }

    /**
     * Populate island job trigger trigger.
     *
     * @return the trigger
     */
    @Bean
    public Trigger populateIslandJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMilliseconds(populateIslandJobIntervalInMilliseconds)
                .withRepeatCount(initialAnimalsCount);

        return TriggerBuilder.newTrigger()
                .forJob(populateIslandJobDetail())
                .withIdentity("populateIslandTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

}

