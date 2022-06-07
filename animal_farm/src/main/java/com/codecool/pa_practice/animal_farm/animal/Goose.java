package com.codecool.pa_practice.animal_farm.animal;

public class Goose extends Animal{
    public static final String NOISE = "Honk";
    private static final int MAX_EGGS = 6;
    private int numberOfLayedEggs = 0;

    public Goose(int weight) {
        super(weight, NOISE);
    }


    public void layEgg() {
        numberOfLayedEggs += random.nextInt(MAX_EGGS);
    }

    public int getNumberOfLayedEggs() {
        System.out.printf("%s layed %d eggs%n", id, numberOfLayedEggs);
        return numberOfLayedEggs;
    }

    @Override
    public String toString() {
        return "Goose{" +
                "id=" + id +
                ", weight=" + weight +
                ", numberOfLayedEggs=" + numberOfLayedEggs +
                '}';
    }
}
