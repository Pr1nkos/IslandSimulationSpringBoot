package ru.pr1nkos.islandsimulation.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pr1nkos.islandsimulation.enums.OmnivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;

import java.util.Arrays;
import java.util.List;

@RestController
public class EnumController {

    @GetMapping("/api/enums/predatorTypes")
    public List<String> getPredatorTypes() {
        return Arrays.stream(PredatorType.values())
                .map(Enum::name)
                .toList();
    }

    @GetMapping("/api/enums/herbivoreTypes")
    public List<String> getHerbivoreTypes() {
        return Arrays.stream(HerbivoreType.values())
                .map(Enum::name)
                .toList();
    }

    @GetMapping("/api/enums/omnivoreTypes")
    public List<String> getOmnivoreTypes() {
        return Arrays.stream(OmnivoreType.values())
                .map(Enum::name)
                .toList();
    }
}
