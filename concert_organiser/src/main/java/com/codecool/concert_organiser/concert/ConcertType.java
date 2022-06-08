package com.codecool.concert_organiser.concert;

import java.math.BigDecimal;
import java.util.Currency;

public enum ConcertType {
    INDOOR(3000, 1.5, new BigDecimal(600), Currency.getInstance("HUF")),
    OUTDOOR(5000, 2, new BigDecimal(800), Currency.getInstance("HUF")),
    FESTIVAL(8000, 6, new BigDecimal(1000), Currency.getInstance("HUF"));


    ConcertType(int capacity, double duration, BigDecimal beerPrice, Currency currency) {
        this.capacity = capacity;
        this.duration = duration;
        this.beerPrice = beerPrice;
        this.currency = currency;
    }

    public final int capacity;
    public final double duration;// in hour

    public final BigDecimal beerPrice;

    public final Currency currency;

    @Override
    public String toString() {
        return "ConcertType{" +
                "\ncapacity=" + capacity +
                "\nduration=" + duration +
                "\nbeerPrice=" + beerPrice.toString() +
                "\ncurrency=" + currency.toString() +
                '}';
    }
}
