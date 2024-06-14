package ru.pr1nkos.islandsimulation;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.pr1nkos.islandsimulation.dto.AnimalCharacteristicsDto;

@Component
@RequiredArgsConstructor
public class TestRunner implements CommandLineRunner {

    private final AnimalCharacteristicsDto animalCharacteristicsDto;

    @Override
    public void run(String... args){
        System.out.println("Eating chances 1: " + animalCharacteristicsDto.getWolf());
        System.out.println("Eating chances 2: " + animalCharacteristicsDto.getCaterpillar());
        System.out.println("Eating chances 3: " + animalCharacteristicsDto.getGoat());
        System.out.println("Eating chances 4: " + animalCharacteristicsDto.getRabbit());
        System.out.println("Eating chances 5: " + animalCharacteristicsDto.getHorse());
        System.out.println("Eating chances 6: " + animalCharacteristicsDto.getBuffalo());
        System.out.println("Eating chances 7: " + animalCharacteristicsDto.getBear());
        System.out.println("Eating chances 8: " + animalCharacteristicsDto.getDuck());
        System.out.println("Eating chances 9: " + animalCharacteristicsDto.getEagle());

    }
}