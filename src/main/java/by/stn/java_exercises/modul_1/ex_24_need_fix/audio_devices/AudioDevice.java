package by.stn.java_exercises.modul_1.ex_24_need_fix.audio_devices;

import by.stn.java_exercises.modul_1.ex_24_need_fix.Device;

/**
 * Created by EugenKrasotkin on 3/2/2018.
 */
public interface AudioDevice extends Device {
    void increaseVolume();
    void decreaseVolume();
}
