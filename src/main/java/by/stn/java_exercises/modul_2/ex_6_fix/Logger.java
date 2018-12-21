package by.stn.java_exercises.modul_2.ex_6_fix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
	private static Logger instance;

	private Logger() {
	}

	public static synchronized Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	public void write(String text) throws IOException {
		try (FileWriter fw = new FileWriter("logger.txt", true)) {//file name constant
			BufferedWriter bufferWriter = new BufferedWriter(fw);//сделать полями класса
			bufferWriter.write("\n");
			bufferWriter.write(text + LocalDateTime.now());
			bufferWriter.flush();
			bufferWriter.close();
		}
	}
}