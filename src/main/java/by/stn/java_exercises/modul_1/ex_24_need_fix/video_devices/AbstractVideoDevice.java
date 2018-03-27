package by.stn.java_exercises.modul_1.ex_24_need_fix.video_devices;

import by.stn.java_exercises.modul_1.ex_24_need_fix.AbstractDevice;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractVideoDevice extends AbstractDevice implements VideoDevice {
    @Getter
    private int displaySize;
    @Getter
    @Setter
    private int contrastLevel;

    public AbstractVideoDevice(int power, String manufacturer, String color, boolean turnedOn, int displaySize, int contrastLevel) {
        super(power, manufacturer, color, turnedOn);
        this.displaySize = displaySize;
        this.contrastLevel = contrastLevel;
    }
}