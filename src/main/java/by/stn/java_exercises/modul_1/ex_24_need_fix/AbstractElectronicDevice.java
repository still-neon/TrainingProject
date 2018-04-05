package by.stn.java_exercises.modul_1.ex_24_need_fix;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractElectronicDevice implements ElectronicDevice {
    @Getter
    private int power;
    @Getter
    private String color;
    @Getter
    @Setter
    private boolean turnedOn;
    @Getter
    @Setter
    private String manufacturer;

    public AbstractElectronicDevice(int power, String manufacturer, String color, boolean turnedOn) {
        this.power = power;
        this.manufacturer = manufacturer;
        this.color = color;
        this.turnedOn = turnedOn;
    }
}