package com.codecool.pa_practice.billiard_saloon;

import com.codecool.pa_practice.billiard_saloon.table.Table;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class BilliardSaloon {
    private List<Table> tables = new ArrayList<>();

    public void addTable(Table table) {
        tables.add(table);
    }

    public boolean startGame(Table table, String customerName, Calendar startTime) {
        Table table1 = tables.stream()
                .filter(table2 -> table2.equals(table))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return table1.startGame(customerName, startTime);
    }

    public BigDecimal endGame(String customerName, Calendar endTime) {
        return tables.stream()
                .filter(table1 -> table1.getCustomerName().equals(customerName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .endgame(endTime);
    }

    public List<Table> getFreeTables() {
        return tables.stream()
                .filter(Table::isFreeTable)
                .collect(Collectors.toList());
    }
}
