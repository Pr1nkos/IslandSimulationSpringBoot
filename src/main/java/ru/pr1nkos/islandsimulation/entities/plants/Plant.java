package ru.pr1nkos.islandsimulation.entities.plants;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * The type Plant.
 */
@Data
@RequiredArgsConstructor
public class Plant {

    private int x;
    private int y;

    private boolean isAlive = true;


}
