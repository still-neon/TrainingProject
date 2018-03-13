package by.stn.java_exercises.modul_1.ex_24;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractDevice implements Device {
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

    public AbstractDevice(int power, String manufacturer, String color, boolean turnedOn) {
        this.power = power;
        this.manufacturer = manufacturer;
        this.color = color;
        this.turnedOn = turnedOn;
    }
}