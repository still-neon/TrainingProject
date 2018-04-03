package by.stn.java_exercises.modul_3.dog_door;

/**
 * Created by EugenKrasotkin on 4/2/2018.
 */
public class BarkRecognizer {
    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark) {
        System.out.println("BarkRecognizer: Heard a '" + bark.getSound() + "'");
        if (door.getAllowedbarks().contains(bark)) {
            door.open();
        } else {
            System.out.println("This dog is not allowed.");
        }
    }
}