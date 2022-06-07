package com.codecool.pa_practice.blockbuster.app;


// start 2022.06.07 21:59
// end 2022.06.08 00:12

import com.codecool.pa_practice.blockbuster.BlockbusterStore;
import com.codecool.pa_practice.blockbuster.product.Product;
import com.codecool.pa_practice.blockbuster.product.ProductType;

import java.math.BigDecimal;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        BlockbusterStore blockbusterStore = new BlockbusterStore();

        Calendar calendar = Calendar.getInstance();
        calendar.set(1976, Calendar.MAY, 4);
        blockbusterStore.addProduct(new Product("Star Wars", calendar , new BigDecimal("2.67"), ProductType.MOVIE));

        calendar = Calendar.getInstance();
        calendar.set(1985, Calendar.APRIL, 4);
        blockbusterStore.addProduct(new Product("Back to the future", calendar , new BigDecimal("4.67"), ProductType.MOVIE));

        calendar = Calendar.getInstance();
        calendar.set(2007, Calendar.MAY, 26);
        blockbusterStore.addProduct(new Product("Guns n Roses", calendar , new BigDecimal("1.32"), ProductType.MUSIC));

        calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.SEPTEMBER, 1);
        blockbusterStore.addProduct(new Product("Game Of Thrones", calendar , new BigDecimal("10.34"), ProductType.TV_SHOW));

//        System.out.println(blockbusterStore);
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -10);
        Product product = blockbusterStore.rentProduct("Star Wars", calendar).orElseThrow(RuntimeException::new);
        System.out.println("ALL PRODUCTS AFTER RENT: \n" + blockbusterStore.getAllProducts());


        calendar = Calendar.getInstance();


        System.out.printf("YOU HAVE TO PAY %s FOR %n%s%n", blockbusterStore.returnProduct(product, calendar), product);
        System.out.println("AVAILABLE PRODUCTS AFTER RETURN PRODUCT: \n" + blockbusterStore.getAvailableProducts());
    }
}
