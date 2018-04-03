package by.stn.java_exercises.modul_3.dog_door;



/**
 * Created by EugenKrasotkin on 4/2/2018.
 */
public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        door.addAllowedBarks(new Bark("rowlf"));
        door.addAllowedBarks(new Bark("rooowlf"));
        door.addAllowedBarks(new Bark("rawlf"));
        door.addAllowedBarks(new Bark("woof"));

        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);

        System.out.println("Bruce starts barking.");

        recognizer.recognize(new Bark("rowlf"));

        System.out.println("\nBruce has gone outside...");

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
        }

        System.out.println("\nBruce all done...");
        System.out.println("...but he's stuck outside!");

        Bark smallDogBark = new Bark("yip");
        System.out.println("A small dog starts barking.");
        recognizer.recognize(smallDogBark);

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
        }

        System.out.println("Bruce starts barking.");
        recognizer.recognize(new Bark("rooowlf"));

        System.out.println("\nBruce has back inside...");
    }
}