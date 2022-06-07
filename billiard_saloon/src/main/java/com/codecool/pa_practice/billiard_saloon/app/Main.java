package com.codecool.pa_practice.billiard_saloon.app;

import com.codecool.pa_practice.billiard_saloon.BilliardSaloon;
import com.codecool.pa_practice.billiard_saloon.order.Order;
import com.codecool.pa_practice.billiard_saloon.order.OrderType;
import com.codecool.pa_practice.billiard_saloon.table.Table;
import com.codecool.pa_practice.billiard_saloon.table.TableType;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

// start 2022.06.07 19:26
// end 2022.06.07 21:12
public class Main {
    public static void main(String[] args) {
        Calendar startTime = Calendar.getInstance();
        startTime.set(2022, Calendar.JUNE, 7, 14, 0, 0);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2022, Calendar.JUNE, 7, 17, 0, 0);
        BilliardSaloon billiardSaloon = new BilliardSaloon();
        billiardSaloon.addTable(new Table(TableType.POOL));
        billiardSaloon.addTable(new Table(TableType.POOL));
        billiardSaloon.addTable(new Table(TableType.POOL));
        billiardSaloon.addTable(new Table(TableType.REX));
        billiardSaloon.addTable(new Table(TableType.REX));
        billiardSaloon.addTable(new Table(TableType.REX));
        billiardSaloon.addTable(new Table(TableType.REX));
        billiardSaloon.addTable(new Table(TableType.REX));
        billiardSaloon.addTable(new Table(TableType.REX));
        billiardSaloon.addTable(new Table(TableType.REX));
        billiardSaloon.addTable(new Table(TableType.SNOOKER));
        billiardSaloon.addTable(new Table(TableType.SNOOKER));
        billiardSaloon.addTable(new Table(TableType.SNOOKER));
        billiardSaloon.addTable(new Table(TableType.SNOOKER));
        billiardSaloon.addTable(new Table(TableType.SNOOKER));
        billiardSaloon.addTable(new Table(TableType.SNOOKER));
        billiardSaloon.addTable(new Table(TableType.SNOOKER));
        billiardSaloon.addTable(new Table(TableType.SNOOKER));

        List<Table> freeTables = billiardSaloon.getFreeTables();
        System.out.println(freeTables.size());
        Table table = freeTables.get(0); //pukihang és nyelvnyújtás. EGYSZERRE
        table.startGame("Joe", startTime);
        table.addOrder(new Order("Cola", new BigDecimal("1"), OrderType.DRINK), 20);
        table.removeOrder(new Order("Cola", new BigDecimal("1"), OrderType.DRINK));
        BigDecimal totalPrice = table.endgame(endTime);
        System.out.println(totalPrice);
    }
}
