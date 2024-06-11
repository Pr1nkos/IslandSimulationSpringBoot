package ru.pr1nkos.islandsimulation.controllers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;
import ru.pr1nkos.islandsimulation.services.AnimalService;
import ru.pr1nkos.islandsimulation.services.IslandService;
import ru.pr1nkos.islandsimulation.services.PlantService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class IslandController {
    private static final String INDEX = "index.html";
    private final AnimalService animalService;
    private final PlantService plantService;
    private final IslandService islandService;

    @GetMapping("/animals")
    public ResponseEntity<?> getAllAnimals() {
        return ResponseEntity.ok(animalService.getAllAnimals());
    }

    @SneakyThrows
    @PostMapping("/animals/predator")
    public String addPredator(@RequestParam PredatorType predatorType, Model model) {
        islandService.addPredator(predatorType);
        String[][] island = islandService.getIsland();
        model.addAttribute("island", island);

        return INDEX;
    }

    @SneakyThrows
    @PostMapping("/animals/herbivore")
    public String addHerbivore(@RequestParam HerbivoreType herbivoreType, Model model) {
        islandService.addHerbivore(herbivoreType);
        String[][] island = islandService.getIsland();
        model.addAttribute("island", island);
        return INDEX;
    }


    @GetMapping("/island")
    public String getIsland(Model model) {
        String[][] island = islandService.getIsland();
        model.addAttribute("island", island);
        return INDEX;
    }
}
