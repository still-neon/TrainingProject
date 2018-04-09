package by.stn.java_exercises.modul_1.ex_24_fixed.audio_devices;

import by.stn.java_exercises.modul_1.ex_24_fixed.AbstractElectronicDevice;

/**
 * Created by EugenKrasotkin on 4/9/2018.
 */
public class MP3Player extends AbstractElectronicDevice {
    public MP3Player(int power) {
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