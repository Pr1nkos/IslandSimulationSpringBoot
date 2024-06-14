package ru.pr1nkos.islandsimulation.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
public class AnimalDto {
    private double baseWeight;
    private int baseMaxCountPerLocation;
    private int baseMaxSpeed;
    private double baseFoodNeeded;
    private Map<String, Integer> eatingChances;
}
