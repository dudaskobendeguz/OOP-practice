package com.codecool.concert_organiser.util;

public class Id {
    private static int id;
    private static Id instance = null;

    private Id() {
        id = 0;
    }

    public static int generate() {
        if (instance == null) {
            instance = new Id();
        }
        return ++Id.id;
    }
}
