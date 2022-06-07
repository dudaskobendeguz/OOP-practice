package com.codecool.pa_practice.blockbuster.product;

public enum PlatformType {
    VHS("VHS"),
    CD("CD"),
    DVD("DVD"),
    BLU_RAY("Blu-Ray");
    final String name;

    PlatformType(String name) {
        this.name = name;
    }
}
