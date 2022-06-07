package com.codecool.pa_practice.animal_farm.animal;

public class Cow extends Mammal{

    public static final String NOISE = "Moo";

    public Cow(int weight) {
        super(weight, NOISE);
    }

    public Cow(int weight, boolean hasBaby, int babyWeight) {
        super(weight, NOISE, hasBaby, babyWeight);
    }
}
