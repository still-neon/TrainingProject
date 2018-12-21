package by.stn.java_exercises.modul_2.ex_6_fix;

import java.io.IOException;

public class Launcher {
    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            try {
                Logger.getInstance().write("Error code: " + (int) (Math.random() * i * 100) + " ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}