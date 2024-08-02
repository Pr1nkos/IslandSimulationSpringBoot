package ru.pr1nkos.islandsimulation.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The type Animal characteristics dto.
 */
@Data
@Component
@ConfigurationProperties(prefix = "animal-characteristics")
public class AnimalCharacteristicsDto {
    private AnimalDto wolf;
    private AnimalDto boa;
    private AnimalDto fox;
    private AnimalDto bear;
    private AnimalDto eagle;
    private AnimalDto horse;
    private AnimalDto deer;
    private AnimalDto rabbit;
    private AnimalDto mouse;
    private AnimalDto goat;
    private AnimalDto sheep;
    private AnimalDto boar;
    private AnimalDto buffalo;
    private AnimalDto duck;
    private AnimalDto caterpillar;
    private AnimalDto plants;
}

