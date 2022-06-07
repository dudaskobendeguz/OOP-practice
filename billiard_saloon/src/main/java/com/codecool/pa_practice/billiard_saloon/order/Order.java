package com.codecool.pa_practice.billiard_saloon.order;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {
    private final String name;
    private final BigDecimal price;
    private final OrderType orderType;

    public Order(String name, BigDecimal price, OrderType orderType) {
        this.name = name;
        this.price = price;
        this.orderType = orderType;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return name.equals(order.name) && price.equals(order.price) && orderType == order.orderType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, orderType);
    }
}
