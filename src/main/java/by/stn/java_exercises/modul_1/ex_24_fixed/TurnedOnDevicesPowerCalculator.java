package by.stn.java_exercises.modul_1.ex_24_fixed;

import by.stn.java_exercises.modul_1.ex_24_fixed.audio_devices.*;

import java.util.ArrayList;
import java.util.List;

class TurnedOnDevicesPowerCalculator {
    private static List<ElectronicDevice> createDevices() {
        List<ElectronicDevice> devices = new ArrayList<>();

        devices.add(new Radio(150));
        devices.add(new Dynamics(125));
        devices.add(new MP3Player(75));
        devices.get(0).turnOn();
        devices.get(2).turnOn();
        return devices;
    }

    private static int calculate(List<ElectronicDevice> devices) {
        int powerSum = 0;
        for(ElectronicDevice device: devices) {
            if(device.isTurnedOn()) {
                powerSum += device.getPower();
            }
        }
        return powerSum;
    }

    public static void main(String args[]) {
        System.out.println("The sum power of turned on devices is " + calculate(createDevices()) + " Wt");
    }
}