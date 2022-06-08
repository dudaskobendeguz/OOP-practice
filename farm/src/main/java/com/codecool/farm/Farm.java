package com.codecool.farm;


import com.codecool.farm.plant.Plant;

import java.util.HashSet;
import java.util.Set;

public class Farm {
    private Set<Plant> plants = new HashSet<>();
    private int totalFoodProduced = 0;
    private int months = 0;

    public void plantingPlant(Plant plant) {
        plants.add(plant);
    }

    public void simulateMonth() {
        increaseMonths();
        produceFood();
        System.out.println("Month: " + months +
                "\nTotal Food Produced: " + totalFoodProduced +
                "\nPlants: " + showPlants() +
                "\n\n");
    }

    private String showPlants() {
        return plants.stream()
                .map(Plant::toString)
                .reduce("", String::concat);
    }

    private void increaseMonths() {
        months++;
    }

    public int getTotalFoodProduced() {
        return totalFoodProduced;
    }

    public void produceFood() {
        totalFoodProduced += plants.stream()
                .map(Plant::produceFood)
                .reduce(0, Integer::sum);
    }
}

