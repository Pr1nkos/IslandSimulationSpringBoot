package ru.pr1nkos.islandsimulation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pr1nkos.islandsimulation.entities.animals.Animal;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;
import ru.pr1nkos.islandsimulation.pojo.Cell;
import ru.pr1nkos.islandsimulation.pojo.IslandData;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AnimalBreedingService {

    private final AnimalManagementService animalManagementService;
    private final IslandData islandData;
    private final Random random = new Random();

    public void breedAnimals() {
        Map<String, Cell> islandCells = islandData.getIslandCells();

        // Получаем список всех ячеек
        List<Cell> cells = List.copyOf(islandCells.values());

        // Выбираем случайную ячейку
        Cell randomCell = cells.get(random.nextInt(cells.size()));

        // Получаем список животных в выбранной ячейке
        List<Animal> animals = randomCell.getAnimals();

        // Выбираем случайную пару животных для размножения
        if (animals.size() >= 2) {
            int index1 = random.nextInt(animals.size());
            int index2;
            do {
                index2 = random.nextInt(animals.size());
            } while (index1 == index2);

            Animal animal1 = animals.get(index1);
            Animal animal2 = animals.get(index2);

            // Проверяем, что животные одного типа и выполняем размножение с заданной вероятностью
            if (animal1.getClass() == animal2.getClass() && random.nextDouble() < getBreedingChance()) {
                AnimalType animalType = animal1.getAnimalType();
                Animal newAnimal = animalManagementService.createAnimal(animalType);
                randomCell.addAnimal(newAnimal);
                System.out.println("New animal of type " + animalType.getType() + " has been born in cell." + animal1.getX() + " " + animal1.getY());
            }
        }
    }

    private double getBreedingChance() {
        return 0.5;
    }
}
