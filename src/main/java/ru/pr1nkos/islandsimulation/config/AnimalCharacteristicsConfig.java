package ru.pr1nkos.islandsimulation.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.pr1nkos.islandsimulation.dto.AnimalCharacteristicsDto;

@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:animalCharacteristics.yml")
@EnableConfigurationProperties(AnimalCharacteristicsDto.class)
public class AnimalCharacteristicsConfig {


}
