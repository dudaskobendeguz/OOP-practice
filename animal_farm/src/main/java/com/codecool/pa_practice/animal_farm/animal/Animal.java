package com.codecool.pa_practice.animal_farm.animal;

import java.util.Random;
import java.util.UUID;

public abstract class Animal {
    protected Random random = new Random();
    protected final UUID id = UUID.randomUUID();
    protected int weight;// In gram
    private final String noise;

    public Animal(int weight, String noise) {
        this.weight = weight;
        this.noise = noise;
    }

    public String makeNoise() {
        return noise;
    }

    public int getWeight() {
        return weight;
    }
}
