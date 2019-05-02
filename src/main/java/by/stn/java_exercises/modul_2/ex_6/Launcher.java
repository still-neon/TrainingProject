package by.stn.java_exercises.modul_2.ex_6;

import java.io.IOException;

public class Launcher {
	public static void main(String args[]) {
		try {
			for (int i = 0; i < 10; i++) {
				Logger.getInstance().write("Error code: " + (int) (Math.random() * i * 100) + " ");
			}
			Logger.getInstance().finish();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}