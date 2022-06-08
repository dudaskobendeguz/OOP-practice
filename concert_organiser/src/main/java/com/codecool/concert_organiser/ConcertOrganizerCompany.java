package com.codecool.concert_organiser;

import com.codecool.concert_organiser.band.Band;
import com.codecool.concert_organiser.concert.Concert;
import com.codecool.concert_organiser.concert.ConcertType;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ConcertOrganizerCompany {
    private Set<Concert> concerts = new HashSet<>();
    private Set<Band> bands = new HashSet<>();
    private static final BigDecimal MINIMUM_TICKET_PRICE = new BigDecimal(12000);
    private static final BigDecimal MAXIMUM_TICKET_PRICE = new BigDecimal(15000);


    public void addBand(Band newBand) {
        bands.add(newBand);
    }

    public boolean organizeConcert(ConcertType concertType, Band mainBand, BigDecimal ticketPrice) {
        if (isValidPrice(ticketPrice)) {
            try {
                Band warmUpBand = findWarmUpBand(mainBand);
                concerts.add(new Concert(concertType, mainBand, warmUpBand, ticketPrice));
            } catch (IllegalArgumentException e) {
                System.out.printf("Cannot Organize concert for %s%n, because we couldn't find any warmup band!!!", mainBand);
                return false;
            }
            return true;
        }
        return false;
    }

    private Band findWarmUpBand(Band mainBand) {
        return bands.stream()
                .filter(band -> !band.equals(mainBand) && band.getStyle().equals(mainBand.getStyle()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isValidPrice(BigDecimal ticketPrice) {
        return ticketPrice.compareTo(MINIMUM_TICKET_PRICE) > 0 || ticketPrice.compareTo(MAXIMUM_TICKET_PRICE) < 0;
    }

    public void sellTicket(int concertId, int numberOfTickets) {
        try {
            Concert concert = getConcertById(concertId);
            concert.buyTickets(numberOfTickets);
        } catch (IllegalArgumentException e) {
            System.out.println("No active concert with this id: " + concertId);
        }
    }

    private Concert getConcertById(int concertId) {
        return concerts.stream()
                .filter(concert1 -> concert1.getId() == concertId)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void sellBeer(int concertId, int numberOfBeers) {
        try {
            Concert concert = getConcertById(concertId);
            for (int i = 0; i < numberOfBeers; i++) {
                concert.sellBeer();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("No active concert with this id: " + concertId);
        }
    }

    public void showConcertDetails(int concertId) {
        try {
            Concert concert = getConcertById(concertId);
            System.out.println(concert);
        } catch (IllegalArgumentException e) {
            System.out.println("No active concert with this id: " + concertId);
        }
    }
}
