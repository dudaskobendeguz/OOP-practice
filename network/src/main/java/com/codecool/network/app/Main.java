package com.codecool.network.app;


//start 2022.06.09 9:20
//end 20122.06.09 10:30

import com.codecool.network.Network;
import com.codecool.network.device.Lightweight;
import com.codecool.network.device.Normal;
import com.codecool.network.device.ScreenType;
import com.codecool.network.device.Smart;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Smart smart = new Smart(1, 20, ScreenType.EDTV, "Telekom");

        Calendar manufactured = Calendar.getInstance();
        manufactured.set(2019, Calendar.MAY, 12, 0, 0);
        Normal normal = new Normal(3, 15, ScreenType.HD, manufactured);

        Lightweight lightWeight = new Lightweight(0, 20);

        network.registerDevice(smart);
        network.registerDevice(normal);
        network.registerDevice(lightWeight);
        network.calculateDevicesRemainingPower();
        System.out.println("hello world");
    }
}
