package com.codecool.pa_practice.animal_farm.animal;

public abstract class Mammal extends Animal{
    public static final int GIVE_BIRTH_CHANCE = 10;
    private boolean hasBaby;
    private int babyWeight;


    public Mammal(int weight, String noise) {
        this(weight, noise, false, 0);
    }

    public Mammal(int weight, String noise, boolean hasBaby, int babyWeight) {
        super(weight, noise);
        this.hasBaby = hasBaby;
        this.babyWeight = babyWeight;
    }

    public void giveBirth() {
        if (hasBaby && random.nextInt(100) <= GIVE_BIRTH_CHANCE) {
            hasBaby = false;
            System.out.printf("%s: give birth. the baby is %d gramm%n", id, babyWeight);
            babyWeight = 0;
        }
        else {
            hasBaby = true;
            babyWeight += (babyWeight != 0) ? babyWeight / 2 : random.nextInt(100);
        }
    }

    @Override
    public int getWeight() {
        return weight + babyWeight;
    }
}
