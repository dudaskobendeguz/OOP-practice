package com.codecool.pa_practice.blockbuster.product;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Objects;

public class Product {
    private final String title;
    private final Calendar releaseDate;
    private final BigDecimal dailyRetailPrice;
    private final PlatformType platformType;
    private Calendar rentedDate;

    public Product(String title, Calendar releaseDate, BigDecimal dailyRetailPrice, ProductType productType) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.dailyRetailPrice = dailyRetailPrice;
        switch (productType) {
            case MUSIC: {
                platformType = PlatformType.CD;
                break;
            }
            case VIDEO_GAME: {
                platformType = PlatformType.DVD;
                break;
            }
            case MOVIE:
            case TV_SHOW: {
                int releaseYear = releaseDate.get(Calendar.YEAR);
                if (releaseYear < 2000) {
                    platformType = PlatformType.VHS;
                } else if (releaseYear < 2010) {
                    platformType = PlatformType.DVD;
                } else {
                    platformType = PlatformType.BLU_RAY;
                }
                break;
            }
            default: {
                throw new DateTimeException("Invalid date for adding product: " + releaseDate);
            }
        }
    }

    public Calendar getRentedDate() {
        return rentedDate;
    }

    public void setRentedDate(Calendar rentedDate) {
        this.rentedDate = rentedDate;
    }

    public boolean isAvailable() {
        return rentedDate == null;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getDailyRetailPrice() {
        return dailyRetailPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return title.equals(product.title) && releaseDate.equals(product.releaseDate) && dailyRetailPrice.equals(product.dailyRetailPrice) && platformType == product.platformType && Objects.equals(rentedDate, product.rentedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, dailyRetailPrice, platformType, rentedDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "title = '" + title + '\'' +
                "\n releaseDate = " + releaseDate.getTime() +
                "\n dailyRetailPrice = " + dailyRetailPrice +
                "\n platformType = " + platformType.name +
                "\n rented = " + ((rentedDate != null) ? rentedDate.getTime() : "Not Rented" )+
                "\n" + '}' + "\n";
    }
}
