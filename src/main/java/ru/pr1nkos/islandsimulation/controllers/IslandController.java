package ru.pr1nkos.islandsimulation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pr1nkos.islandsimulation.enums.HerbivoreType;
import ru.pr1nkos.islandsimulation.enums.PredatorType;
import ru.pr1nkos.islandsimulation.services.AnimalManagementService;
import ru.pr1nkos.islandsimulation.services.IslandInformationService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class IslandController {

    private final AnimalManagementService animalManagementService;
    private final IslandInformationService islandInformationService;

    @GetMapping("/island")
    public String getIsland(Model model) {
        String[][] island = islandInformationService.getIsland();
        model.addAttribute("island", island);
        return "index";
    }


    @PostMapping("/animals/predator")
    public ResponseEntity<Void> addPredator(@RequestParam PredatorType predatorType) {
        animalManagementService.addPredator(predatorType);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/animals/herbivore")
    public ResponseEntity<Void> addHerbivore(@RequestParam HerbivoreType herbivoreType) {
        animalManagementService.addHerbivore(herbivoreType);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/island/cell")
    public ResponseEntity<List<String>> getCellAnimalSymbols(@RequestParam int x, @RequestParam int y) {
        try {
            List<String> animalSymbols = islandInformationService.getAnimalSymbolsInCell(x, y);
            return ResponseEntity.ok(animalSymbols);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
