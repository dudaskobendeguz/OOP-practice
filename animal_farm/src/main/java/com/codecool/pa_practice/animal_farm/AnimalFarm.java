package com.codecool.pa_practice.animal_farm;

import com.codecool.pa_practice.animal_farm.animal.Animal;
import com.codecool.pa_practice.animal_farm.animal.Dog;
import com.codecool.pa_practice.animal_farm.animal.Goose;
import com.codecool.pa_practice.animal_farm.animal.Mammal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;


public class AnimalFarm {
    public static final int MAX_HOLE_NUMBER = 10;
    private Set<Animal> animals = new HashSet<>();

    public void addAnimal(Animal... newAnimals) {
        animals.addAll(Arrays.asList(newAnimals));
    }

    public void layEggs() {
        animals.forEach(animal -> {
            if (animal instanceof Goose) {
                ((Goose) animal).layEgg();
            }
        });
    }

    public void digHoles() {
        animals.forEach(animal -> {
            if (animal instanceof Dog) {
                if (((Dog) animal).getDiggedHolesNumber() < MAX_HOLE_NUMBER) {
                    ((Dog) animal).digHole();
                }
            }
        });
    }

    public Goose getGoldenGoose() {
        return animals.stream()
                .filter(animal -> animal instanceof Goose)
                .map(animal -> ((Goose) animal))
                .max(Comparator.comparing(Goose::getNumberOfLayedEggs)).orElse(null);
    }

    public void giveBirth() {
        animals.forEach(animal -> {
            if (animal instanceof Mammal) {
                ((Mammal) animal).giveBirth();
            }
        });
    }
}
