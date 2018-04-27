package by.stn.java_exercises.modul_1.ex_24;

public abstract class AbstractElectronicDevice implements ElectronicDevice {
    private int power;
    private boolean isOn;

    public AbstractElectronicDevice(int power) {
        this.isOn = false;
        this.power = power;
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public int getPower() {
        return power;
    }
}