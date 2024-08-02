package ru.pr1nkos.islandsimulation.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * The type Random manager.
 */
@Service
public class RandomManager {

    private final Random random = new Random();

    /**
     * Next int int.
     *
     * @param bound the bound
     * @return the int
     */
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    /**
     * Next double.
     *
     * @return the double
     */
    public double nextDouble() {
        return random.nextDouble();
    }

    /**
     * Gets random element.
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return the random element
     */
    public <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

    /**
     * Next int excluding int.
     *
     * @param bound   the bound
     * @param exclude the exclude
     * @return the int
     */
    public int nextIntExcluding(int bound, int exclude) {
        int value;
        do {
            value = random.nextInt(bound);
        } while (value == exclude);
        return value;
    }
}
