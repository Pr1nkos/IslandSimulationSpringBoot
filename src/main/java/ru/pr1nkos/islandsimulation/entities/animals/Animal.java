package ru.pr1nkos.islandsimulation.entities.animals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.AnimalType;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;
import ru.pr1nkos.islandsimulation.entities.plants.Plant;
import ru.pr1nkos.islandsimulation.pojo.Cell;
import ru.pr1nkos.islandsimulation.services.RandomManager;

import java.util.Map;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Animal implements EatingBehavior, MovingBehavior, ReproducingBehavior {

    protected double weight;
    private int baseMaxCountPerLocation;
    protected int maxSpeed;
    protected double foodNeed;
    protected EatingBehavior eatingBehavior;
    protected MovingBehavior movingBehavior;
    protected ReproducingBehavior reproducingBehavior;
    private boolean isAlive;
    private Map<String, Integer> eatingChances;
    private int x;
    private int y;


    private RandomManager randomManager;

    protected Animal(double baseWeight,
                     int baseMaxCountPerLocation,
                     int baseMaxSpeed,
                     double baseFoodNeeded,
                     EatingBehavior eatingBehavior,
                     MovingBehavior movingBehavior,
                     ReproducingBehavior reproducingBehavior,
                     Map<String, Integer> eatingChances,
                     RandomManager randomManager) {
        this.eatingBehavior = eatingBehavior;
        this.movingBehavior = movingBehavior;
        this.reproducingBehavior = reproducingBehavior;
        this.eatingChances = eatingChances;
        this.isAlive = true;
        this.randomManager = randomManager;
        initialize(baseWeight, baseMaxCountPerLocation, baseMaxSpeed, baseFoodNeeded);
    }

    private void initialize(double baseWeight,
                            int baseMaxCountPerLocation,
                            int baseMaxSpeed,
                            double baseFoodNeeded) {
        this.weight = baseWeight + (randomManager.nextDouble() * 10 - 5);
        this.baseMaxCountPerLocation = baseMaxCountPerLocation;
        this.maxSpeed = Math.max(0, baseMaxSpeed > 0 ? baseMaxSpeed - randomManager.nextInt(baseMaxSpeed) : 0);
        this.foodNeed = baseFoodNeeded + (randomManager.nextDouble() * 2 - 1);
        this.isAlive = true;
    }

    @Override
    public void eat(Animal predator, Animal prey) {
        if (prey.isAlive()) {
            eatingBehavior.eat(predator, prey);
            if (!prey.isAlive()) {
                System.out.println(prey.getClass().getSimpleName() + " был съеден");
            }
        } else {
            System.out.println("Нельзя съесть мертвое животное.");
        }
    }

    @Override
    public void eatPlant(Animal herbivore, Plant plant) {
        if (plant.isAlive()) {
            eatingBehavior.eatPlant(herbivore, plant);
        } else {
            System.out.println("Нельзя съесть мертвое растение.");
        }
    }

    @Override
    public void move(Animal animal, Map<String, Cell> islandMap) {
        if (isAlive()) {
            movingBehavior.move(animal, islandMap);
        } else {
            System.out.println("Мертвое животное не может двигаться.");
        }
    }

    @Override
    public void reproduce() {
        if (isAlive()) {
            reproducingBehavior.reproduce();
        } else {
            System.out.println("Мертвое животное не может размножаться.");
        }
    }

    public abstract AnimalType getAnimalType();
}
