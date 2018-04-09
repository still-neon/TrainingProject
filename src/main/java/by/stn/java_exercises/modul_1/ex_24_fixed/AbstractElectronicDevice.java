package by.stn.java_exercises.modul_1.ex_24_fixed;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractElectronicDevice implements ElectronicDevice {
    @Getter
    private int powerValue;
    @Getter
    @Setter
    private boolean isOn;

    public AbstractElectronicDevice(int power) {
        isOn = false;
        this.powerValue = power;
    }
}