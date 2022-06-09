package com.codecool.network.device;

public enum ScreenType {
    EDTV(5),
    HD(10),
    FULL_HD(15),
    UHD(20);
    public final int powerCapacity;

    ScreenType(int powerCapacity) {
        this.powerCapacity = powerCapacity;
    }
}
