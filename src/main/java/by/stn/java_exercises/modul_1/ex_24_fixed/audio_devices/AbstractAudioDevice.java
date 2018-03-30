package by.stn.java_exercises.modul_1.ex_24_fixed.audio_devices;

import by.stn.java_exercises.modul_1.ex_24_fixed.AbstractDevice;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractAudioDevice extends AbstractDevice implements AudioDevice {
    @Getter
    private int sensitivity;
    @Getter
    @Setter
    private int volumeLevel;

    public AbstractAudioDevice(int power, String manufacturer, String color, boolean turnedOn, int sensitivity, int volumeLevel) {
        super(power, manufacturer, color, turnedOn);
        this.sensitivity = sensitivity;
        this.volumeLevel = volumeLevel;
    }
}