package ru.pr1nkos.islandsimulation.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RandomManager {

    private final Random random = new Random();

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public double nextDouble() {
        return random.nextDouble();
    }

    public <T> T getRandomElement(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

    public int nextIntExcluding(int bound, int exclude) {
        int value;
        do {
            value = random.nextInt(bound);
        } while (value == exclude);
        return value;
    }
}
