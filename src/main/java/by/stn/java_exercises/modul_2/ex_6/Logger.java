package by.stn.java_exercises.modul_2.ex_6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
	private static Logger instance;

	public static synchronized Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	public void write(String text) {
		try (FileWriter fw = new FileWriter("logger.txt", true)) {
			BufferedWriter bufferWriter = new BufferedWriter(fw);
			bufferWriter.write("\n");
			bufferWriter.write(text + LocalDateTime.now());
			bufferWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}