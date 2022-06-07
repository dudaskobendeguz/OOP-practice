package com.codecool.pa_practice.billiard_saloon.table;

import java.math.BigDecimal;

public enum TableType {
    POOL("Pool", new BigDecimal(1200)),
    SNOOKER("Snooker", new BigDecimal(1600)),
    REX("Rex", new BigDecimal(800));
    final String name;
    final BigDecimal price;


    TableType(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
