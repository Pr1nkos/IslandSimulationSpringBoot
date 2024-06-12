package ru.pr1nkos.islandsimulation.entities.animals.behaviors;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.pr1nkos.islandsimulation.entities.animals.interfaces.ReproducingBehavior;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class DefaultReproducingBehavior implements ReproducingBehavior {
    @Override
    public void reproduce() {
        System.out.println("Животное размножается");
    }
}
