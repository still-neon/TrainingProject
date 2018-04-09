package by.stn.java_exercises.modul_1.ex_24_fixed.audio_devices;


import by.stn.java_exercises.modul_1.ex_24_fixed.AbstractElectronicDevice;

public class Radio extends AbstractElectronicDevice {
    public Radio(int power) {
        super(power);
    }

    @Override
    public void turnOn() {
        setOn(true);
    }

    @Override
    public boolean isTurnedOn() {
        return isOn();
    }

    @Override
    public int getPower() {
        return getPowerValue();
    }
}