package by.stn.java_exercises.modul_1.ex_24;

public abstract class AbstractElectronicDevice implements ElectronicDevice {
    private int powerValue;
    private boolean isOn;

    public AbstractElectronicDevice(int power) {
        this.isOn = false;
        this.powerValue = power;
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public boolean isTurnedOn() {
        return isOn;
    }

    @Override
    public int getPower() {
        return powerValue;
    }
}