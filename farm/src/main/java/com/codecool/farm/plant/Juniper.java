package com.codecool.farm.plant;

public class Juniper extends EverGreen {


    public static final int DEFAULT_FOOD_PRODUCE_RATE = 14;

    public Juniper() {
        super(DEFAULT_FOOD_PRODUCE_RATE, "Juniper");
    }

    @Override
    public int produceFood() {
        increaseMounts();
        growLeaves();
        return foodProduceRate;
    }
}
