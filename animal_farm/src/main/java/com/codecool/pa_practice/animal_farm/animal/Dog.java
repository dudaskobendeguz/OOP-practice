package com.codecool.pa_practice.animal_farm.animal;

public class Dog extends Mammal{
    private static final String NOISE = "Woof";
    private DogType dogType;
    private int numberOfHoles = 0;

    public Dog(int weight, DogType dogType) {
        super(weight, NOISE);
        this.dogType = dogType;
    }

    public Dog(int weight, boolean hasBaby, int babyWeight, DogType dogType) {
        super(weight, NOISE, hasBaby, babyWeight);
        this.dogType = dogType;
    }

    public void digHole() {
        numberOfHoles++;
    }

    public int getDiggedHolesNumber() {
        return numberOfHoles;
    }
}
