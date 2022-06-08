package com.codecool.farm.plant;

public abstract class EverGreen extends Plant {
    protected static final int MAX_PRODUCTION_RATE = 70;
    private final String name;
    private int monthsLived;

    public EverGreen(int foodProduce, String name) {
        super(foodProduce);
        this.name = name;
        monthsLived = 0;
    }

    public void growLeaves() {
        if (monthsLived % 5 == 0) {
            if (foodProduceRate >= MAX_PRODUCTION_RATE) {
                speak();
            } else {
                foodProduceRate += 5;
            }
        }
    }

    protected void increaseMounts() {
        monthsLived++;
    }

    public void speak() {
        System.out.printf("%s-%s at full production", id, name);
    }

}
