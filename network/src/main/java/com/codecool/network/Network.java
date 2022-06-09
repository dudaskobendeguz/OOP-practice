package com.codecool.network;

import com.codecool.network.device.Device;
import com.codecool.network.device.Lightweight;
import com.codecool.network.device.Smart;

import java.util.HashSet;
import java.util.Set;

public class Network {
    private Set<Device> devices = new HashSet<>();


    public void registerDevice(Device device) {
        if (device instanceof Smart smartDevice && isRegisteredDeviceName(smartDevice)) {
            throw new IllegalArgumentException("This device name has already registered: " + smartDevice.getName());
        }
        if (device instanceof Lightweight lightweightDevice) {
            registerLightWeightDevice(lightweightDevice);
        }
        devices.add(device);
    }

    private void registerLightWeightDevice(Lightweight lightweightDevice) {
        devices.forEach(device -> {
            if (device instanceof Lightweight lightweightDevice1) {
                lightweightDevice1.addNewLightweightDevice();
                lightweightDevice.addNewLightweightDevice();
            }
        });
    }

    private boolean isRegisteredDeviceName(Smart smartDevice) {
        return devices.stream().anyMatch(device -> device instanceof Smart smartDevice1 && smartDevice1.getName().equals(smartDevice.getName()));
    }


    public void calculateDevicesRemainingPower() {
        devices.forEach(System.out::println);
    }
}
