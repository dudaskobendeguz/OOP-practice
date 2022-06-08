package com.codecool.farm.plant;

public class AlmondTree extends Plant implements MushroomGrower, Rotable {
    private static final int DEFAULT_FOOD_PRODUCE_RATE = 50;
    private static final int LOWEST_PRODUCE_RATE = 40;
    private static final int MUSHROOM_GROWING_CHANCE = 8;
    private static final int BOOST_PRODUCTION_RATE = 10;
    private static final int ROT_CHANCE = 13;
    private static final int REDUCE_PRODUCTION_RATE = 18;

    public AlmondTree() {
        super(DEFAULT_FOOD_PRODUCE_RATE);
    }

    @Override
    public int produceFood() {
        if (isRot()) {
            rot();
            return 0;
        }
        if (growMushroom()) {
            boostProductionRate();
        }
        if (isProduceRateLow()) {
            doubleProduceRate();
        }
        return foodProduceRate;
    }

    @Override
    public boolean isRot() {
        return random.nextInt(1, 101) <= ROT_CHANCE;
    }

    @Override
    public void rot() {
        foodProduceRate -= REDUCE_PRODUCTION_RATE;
    }

    @Override
    public boolean growMushroom() {
        return random.nextInt(1, 101) <= MUSHROOM_GROWING_CHANCE;
    }

    private void boostProductionRate() {
        foodProduceRate += BOOST_PRODUCTION_RATE;
    }

    private boolean isProduceRateLow() {
        return foodProduceRate < LOWEST_PRODUCE_RATE;
    }

    private void doubleProduceRate() {
        foodProduceRate *= 2;
    }
}
