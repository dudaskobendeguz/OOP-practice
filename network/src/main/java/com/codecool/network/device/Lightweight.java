package com.codecool.network.device;

public class Lightweight extends Device {
    private static final int POWER_LOSS_PER_YEAR = 7;
    private int numberOfLightweightDevicesOnNetwork = 0;

    public Lightweight(int age, int batteryLife) {
        super(age, batteryLife);
    }

    public void addNewLightweightDevice() {
        numberOfLightweightDevicesOnNetwork++;
    }

    public void removeLightweightDevice() {
        numberOfLightweightDevicesOnNetwork--;
    }

    @Override
    public double calculateRemainingPower() {
        return batteryLife - (POWER_LOSS_PER_YEAR * age);
    }

}
