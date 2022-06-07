package com.codecool.pa_practice.animal_farm.animal;

public class Cat extends Mammal{

    public static final String NOISE = "Meow";

    public Cat(int weight) {
        super(weight, NOISE);
    }

    public Cat(int weight, boolean hasBaby, int babyWeight) {
        super(weight, NOISE, hasBaby, babyWeight);
    }
}
