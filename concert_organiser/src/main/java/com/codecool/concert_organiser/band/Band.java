package com.codecool.concert_organiser.band;

import java.util.Objects;

public class Band {
    private final String name;
    private final Style style;

    public Band(String name, Style style) {
        this.name = name;
        this.style = style;
    }


    public Style getStyle() {
        return style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Band band)) return false;
        return name.equals(band.name) && style == band.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, style);
    }

    @Override
    public String toString() {
        return "Band{" +
                "name='" + name + '\'' +
                ", style=" + style.name +
                '}';
    }
}
