package com.codecool.network.device;

public abstract class Device {
    protected int age;
    protected final int batteryLife;

    public Device(int age, int batteryLife) {
        this.age = age;
        this.batteryLife = batteryLife;
    }

    public abstract double calculateRemainingPower();

    @Override
    public String toString() {
        return "Device{" +
                "\nage=" + age +
                "\nbatteryLife=" + batteryLife +
                "\n remaining power: " + calculateRemainingPower() +
                '}' + "\n\n";
    }
}
