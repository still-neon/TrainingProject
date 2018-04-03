package by.stn.java_exercises.modul_3.dog_door;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 4/2/2018.
 */
public class Bark {
    @Getter
    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public boolean equals(Object bark) {
        if (bark instanceof Bark) {
            Bark otherBark = (Bark) bark;
            return otherBark.getSound().equals(sound);
        } else
            return false;
    }
}