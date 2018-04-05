package by.stn.java_exercises.modul_1.ex_24_need_fix.audio_devices;

import by.stn.java_exercises.modul_1.ex_24_need_fix.ElectronicDevice;

/**
 * Created by EugenKrasotkin on 3/2/2018.
 */
public interface AudioElectronicDevice extends ElectronicDevice {
    void increaseVolume();
    void decreaseVolume();
}
