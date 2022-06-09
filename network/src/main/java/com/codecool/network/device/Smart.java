package com.codecool.network.device;

public class Smart extends ScreenDevice {
    private static final int POWER_LOSS_PER_YEAR = 15;
    private String name;


    public Smart(int age, int batteryLife, ScreenType screenType, String name) {
        super(age, batteryLife, screenType);
        this.name = name;
    }

    @Override
    public double calculateRemainingPower() {
        return batteryLife - (POWER_LOSS_PER_YEAR * age) - screenType.powerCapacity;
    }

    public String getName() {
        return name;
    }
}
