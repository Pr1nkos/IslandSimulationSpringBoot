package ru.pr1nkos.islandsimulation.entities.animals.behaviors;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.MovingBehavior;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class DefaultMovingBehavior implements MovingBehavior {
    @Override
    public void move() {
        System.out.println("Животное двигается");
    }
}
