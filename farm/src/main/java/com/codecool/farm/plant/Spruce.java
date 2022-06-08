package com.codecool.farm.plant;

public class Spruce extends EverGreen implements MushroomGrower, Rotable {
    private static final int DEFAULT_FOOD_PRODUCE_RATE = 26;
    private static final int LOWEST_PRODUCE_RATE = 40;
    private static final int MUSHROOM_GROWING_CHANCE = 5;
    private static final int BOOST_PRODUCTION_RATE = 15;
    private static final int ROT_CHANCE = 4;
    private static final int REDUCE_PRODUCTION_RATE = 20;

    public Spruce() {
        super(DEFAULT_FOOD_PRODUCE_RATE, "Spruce");
    }

    @Override
    public int produceFood() {
        increaseMounts();
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
        growLeaves();
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
