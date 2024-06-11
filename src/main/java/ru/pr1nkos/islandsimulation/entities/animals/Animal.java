package ru.pr1nkos.islandsimulation.entities.animals;


import lombok.RequiredArgsConstructor;

import ru.pr1nkos.islandsimulation.entities.animals.interfaces.EatingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;

import java.math.BigDecimal;
import java.util.Random;

@RequiredArgsConstructor
public abstract class Animal implements EatingBehavior, MovingBehavior, ReproducingBehavior {

    private Long id;
    protected BigDecimal weight;
    protected int maxCountPerCell;
    protected int maxSpeed;
    protected BigDecimal foodNeed;


    protected EatingBehavior eatingBehavior;

    protected MovingBehavior movingBehavior;

    protected ReproducingBehavior reproducingBehavior;

    protected Animal(double baseWeight, int baseMaxCountPerLocation, int baseMaxSpeed, double baseFoodNeeded,
                     EatingBehavior eatingBehavior, MovingBehavior movingBehavior, ReproducingBehavior reproducingBehavior) {
        Random random = new Random();
        this.weight = BigDecimal.valueOf(baseWeight + (random.nextDouble() * 10 - 5)); // Случайное отклонение ±5
        this.maxCountPerCell = baseMaxCountPerLocation;
        this.maxSpeed = baseMaxSpeed + random.nextInt(3) - 1; // Случайное отклонение ±1
        this.foodNeed = BigDecimal.valueOf(baseFoodNeeded + (random.nextDouble() * 2 - 1)); // Случайное отклонение ±1
        this.eatingBehavior = eatingBehavior;
        this.movingBehavior = movingBehavior;
        this.reproducingBehavior = reproducingBehavior;
    }

    @Override
    public void eat(Animal predator, Animal prey) {
        eatingBehavior.eat(predator, prey);
    }

    @Override
    public void move() {
        movingBehavior.move();
    }

    @Override
    public void reproduce() {
        reproducingBehavior.reproduce();
    }
}
