package com.codecool.pa_practice.animal_farm.app;

import com.codecool.pa_practice.animal_farm.AnimalFarm;
import com.codecool.pa_practice.animal_farm.animal.*;

public class Main {
    public static void main(String[] args) {
        AnimalFarm animalFarm = new AnimalFarm();
        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat(2450);
            Dog dog = new Dog(12450, DogType.HUSKY);
            Cow cow = new Cow(600000);
            Goose goose = new Goose(6000);
            animalFarm.addAnimal(cat, dog, cat, goose);
        }

        for (int i = 0; i < 100; i++) {
            animalFarm.layEggs();
            animalFarm.digHoles();
            animalFarm.giveBirth();
        }
        System.out.println(animalFarm.getGoldenGoose());
    }
}
