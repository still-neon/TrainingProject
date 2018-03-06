package java_exercises.modul_1.ex_24.audio_devices;


import lombok.Getter;

public class Headphones extends AbstractAudioDevice {
    @Getter
    private String type;

    public Headphones(int power, String manufacturer, String color, boolean turnedOn, int sensitivity, int volumeLevel, String type) {
        super(power, manufacturer, color, turnedOn, sensitivity, volumeLevel);
        this.type = type;
    }

    public void turnOn() {
        setTurnedOn(true);
    }

    public void turnOff() {
        setTurnedOn(false);
    }

    public void increaseVolume() {
        setVolumeLevel(getVolumeLevel()+1);
    }

    public void decreaseVolume() {
        setVolumeLevel(getVolumeLevel()-1);
    }
}