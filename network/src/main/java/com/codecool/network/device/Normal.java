package com.codecool.network.device;

import java.util.Calendar;

public class Normal extends ScreenDevice {
    private static final int POWER_LOSS_PER_YEAR = 3;
    private final Calendar manufactured;

    public Normal(int age, int batteryLife, ScreenType screenType, Calendar manufactured) {
        super(age, batteryLife, screenType);
        this.manufactured = manufactured;
    }

    @Override
    public double calculateRemainingPower() {
        if (manufactured.getWeekYear() >= 2000) {
            return batteryLife - ((POWER_LOSS_PER_YEAR * 2) * age);
        } else {
            return batteryLife - ((double)(POWER_LOSS_PER_YEAR / 2) * age);
        }
    }

}
