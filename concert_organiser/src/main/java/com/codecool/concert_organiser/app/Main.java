package com.codecool.concert_organiser.app;


//start 2022.06.08 15:06
//end 2022.06.08 16:40
import com.codecool.concert_organiser.ConcertOrganizerCompany;
import com.codecool.concert_organiser.band.Band;
import com.codecool.concert_organiser.band.Style;
import com.codecool.concert_organiser.concert.ConcertType;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ConcertOrganizerCompany concertOrganizerCompany = new ConcertOrganizerCompany();
        Band metalAdamBand = new Band("MetalAdam", Style.ROCK);
        Band metallica = new Band("Metallica", Style.ROCK);
        Band jazzBand = new Band("Jazz4Life", Style.JAZZ);
        concertOrganizerCompany.addBand(metalAdamBand);
        concertOrganizerCompany.addBand(metallica);
        concertOrganizerCompany.addBand(jazzBand);
        boolean willBeConcert = concertOrganizerCompany.organizeConcert(ConcertType.FESTIVAL, metallica, new BigDecimal(14500));
        if (willBeConcert) {
            concertOrganizerCompany.sellTicket(1, 3000);
            concertOrganizerCompany.sellBeer(1, 16000);
        }
        concertOrganizerCompany.showConcertDetails(1);
    }
}
