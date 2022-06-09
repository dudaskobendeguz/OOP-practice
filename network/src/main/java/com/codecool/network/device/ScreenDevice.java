package com.codecool.network.device;

public abstract class ScreenDevice extends Device {
    protected final ScreenType screenType;

    public ScreenDevice(int age, int batteryLife, ScreenType screenType) {
        super(age, batteryLife);
        this.screenType = screenType;
    }
}
