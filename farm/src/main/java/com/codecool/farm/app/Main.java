package com.codecool.farm.app;


import com.codecool.farm.Farm;
import com.codecool.farm.plant.AlmondTree;
import com.codecool.farm.plant.Juniper;
import com.codecool.farm.plant.Spruce;

//start 2022.06.08 18:44
//end 2022.06.8 21:32(Vivien ma vizsgázott barista képzésen, és átment <3. vele beszélgettem kb 1 órát)
public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        AlmondTree almondTree = new AlmondTree();
        Juniper juniper = new Juniper();
        Spruce spruce = new Spruce();
        farm.plantingPlant(almondTree);
        farm.plantingPlant(juniper);
        farm.plantingPlant(spruce);

        for (int i = 0; i < 10; i++) {
            farm.simulateMonth();
        }
    }
}
