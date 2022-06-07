package com.codecool.pa_practice.blockbuster;

import com.codecool.pa_practice.blockbuster.product.Product;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BlockbusterStore {
    private UUID id = UUID.randomUUID();
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }


    public List<Product> getAvailableProducts() {
        return products.stream()
                .filter(Product::isAvailable)
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return List.copyOf(products);
    }

    public Optional<Product> rentProduct(String title, Calendar rentDate) {
        Optional<Product> product = products.stream()
                .filter(product1 -> product1.getTitle().equals(title) && product1.isAvailable())
                .findFirst();
        if (product.isEmpty()) return product;
        else product.get().setRentedDate(rentDate);
        return product;
    }

    public BigDecimal returnProduct(Product returnedProduct, Calendar returnDate) {
        Product product = products.stream()
                .filter(product1 -> product1.equals(returnedProduct))
                .findFirst().orElseThrow(IllegalArgumentException::new);
        long rentedDays = daysBetween(product.getRentedDate(), returnDate);
        product.setRentedDate(null);
        return product.getDailyRetailPrice().multiply(new BigDecimal(rentedDays));
    }

    private static long daysBetween(Calendar startDate, Calendar endDate) {
        long end = endDate.getTimeInMillis();
        long start = startDate.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
    }

    @Override
    public String toString() {
        return "BlockbusterStore{" +
                "id=" + id +
                "\n products=" + products +
                '}';
    }
}
