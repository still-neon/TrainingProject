package by.stn.java_exercises.modul_3.dog_door;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by EugenKrasotkin on 4/2/2018.
 */
public class DogDoor {
    @Getter
    private List<Bark> allowedbarks;
    private boolean open;

    public DogDoor() {
        allowedbarks = new LinkedList<>();
        open = false;
    }

    public void addAllowedBarks(Bark bark) {
        allowedbarks.add(bark);
    }

    public void open() {
        System.out.println("The dog door opens");
        open = true;

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                close();
                timer.cancel();
            }
        }, 5000);
    }

    public void close() {
        System.out.println("The dog door closes");
        open = false;
    }
    public boolean isOpen() {
        return open;
    }
}