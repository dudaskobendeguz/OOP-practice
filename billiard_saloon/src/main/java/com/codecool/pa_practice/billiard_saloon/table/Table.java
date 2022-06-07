package com.codecool.pa_practice.billiard_saloon.table;

import com.codecool.pa_practice.billiard_saloon.order.Order;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * pukihang és nyelvnyújtás. EGYSZERRE
 */
public class Table {
    private Calendar startTime;
    private String customerName = null;
    private final TableType tableType;
    private Map<Order, Integer> ordersWithQuantity = new HashMap<>();

    public Table(TableType tableType) {
        this.tableType = tableType;
    }

    public boolean startGame(String customerName, Calendar startTime) {
        if (this.customerName == null) {
            this.customerName = customerName;
            this.startTime = startTime;
            return true;
        } else {
            return false;
        }
    }

    public void addOrder(Order order, Integer quantity) {
        ordersWithQuantity.merge(order, quantity, Integer::sum);
    }


    public BigDecimal endgame(Calendar endTime) {
        int playedHours = endTime.get(Calendar.HOUR) - startTime.get(Calendar.HOUR);
        BigDecimal totalPrice = new BigDecimal(tableType.price.intValue() * playedHours);
        for (Map.Entry<Order, Integer> orderEntry : ordersWithQuantity.entrySet()) {
            Order order = orderEntry.getKey();
            Integer quantity = orderEntry.getValue();
            for (int i = 0; i < quantity; i++) {
                totalPrice = totalPrice.add(order.getPrice());
            }
        }
        return totalPrice;
    }
    
    public void resetTable() {
        customerName = null;
        startTime = null;
        ordersWithQuantity = new HashMap<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public Map<Order, Integer> getOrdersWithQuantity() {
        return Map.copyOf(ordersWithQuantity);
    }

    public void removeOrder(Order order) {
        if (ordersWithQuantity.get(order) == null) {
            throw new IllegalArgumentException(order + " Order not in orders list: " + ordersWithQuantity);
        }
        if (ordersWithQuantity.get(order) <= 1) {
            ordersWithQuantity.remove(order);
        } else {
            ordersWithQuantity.merge(order, -1, Integer::sum);
        }
    }

    public boolean isFreeTable() {
        return customerName == null;
    }

    public BigDecimal getTablePrice() {
        return tableType.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table)) return false;
        Table table = (Table) o;
        return Objects.equals(startTime, table.startTime) && Objects.equals(customerName, table.customerName) && tableType == table.tableType && ordersWithQuantity.equals(table.ordersWithQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, customerName, tableType, ordersWithQuantity);
    }
}
