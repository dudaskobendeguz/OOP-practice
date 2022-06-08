package com.codecool.concert_organiser.concert;

import com.codecool.concert_organiser.band.Band;
import com.codecool.concert_organiser.util.Id;

import java.math.BigDecimal;

public class Concert {
    private final int id = Id.generate();
    private final ConcertType concertType;
    private final Band mainBand;
    private final Band warmUpBand;
    private BigDecimal ticketPrice;
    private int ticketsLeft;
    private int beersSold;
    private BigDecimal income = new BigDecimal(0);

    public Concert(ConcertType concertType, Band mainBand, Band warmUpBand, BigDecimal ticketPrice) {
        this.concertType = concertType;
        this.mainBand = mainBand;
        this.warmUpBand = warmUpBand;
        this.ticketPrice = ticketPrice;
        ticketsLeft = concertType.capacity;
    }


    public void buyTickets(int numberOfTickets) {
        if (numberOfTickets > ticketsLeft) {
            System.out.printf("You can't by %s ticket(s).%nOnly%s ticket(s) left", numberOfTickets, ticketsLeft);
            return;
        }
        ticketsLeft -= numberOfTickets;
        income = income.add(ticketPrice.multiply(new BigDecimal(numberOfTickets)));
    }

    public int getTicketsLeft() {
        return ticketsLeft;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void sellBeer() {
        beersSold++;
        income = income.add(concertType.beerPrice);
    }

    public BigDecimal getBeerPrice() {
        return concertType.beerPrice;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "\nid=" + id +
                "\n" + concertType +
                "\nmainBand=" + mainBand +
                "\nwarmUpBand=" + warmUpBand +
                "\nticketPrice=" + ticketPrice +
                "\nticketsLeft=" + ticketsLeft +
                "\nbeersSold=" + beersSold +
                "\nincome=" + income +
                '}';
    }
}
