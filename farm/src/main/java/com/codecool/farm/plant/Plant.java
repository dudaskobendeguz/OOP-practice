package com.codecool.farm.plant;

import java.util.UUID;

public abstract class Plant {
    protected final UUID id = UUID.randomUUID();
    protected int growingRate = 4;
    protected int foodProduceRate;

    public Plant(int foodProduce) {
        this.foodProduceRate = foodProduce;
    }

    public abstract int produceFood();

    @Override
    public String toString() {
        return "Plant{" +
                "\nid=" + id +
                "\ngrowingRate=" + growingRate +
                "\nfoodProduceRate=" + foodProduceRate +
                '}';
    }
}
