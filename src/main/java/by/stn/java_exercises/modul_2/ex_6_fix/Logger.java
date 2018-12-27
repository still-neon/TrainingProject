package by.stn.java_exercises.modul_2.ex_6_fix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
	private static final String FILE_NAME = "logger.txt";
	private static Logger instance;
	private FileWriter fw;
	private BufferedWriter bufferWriter;

	private Logger() {
		try {
			fw = new FileWriter(FILE_NAME, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bufferWriter = new BufferedWriter(fw);

	}

	public static synchronized Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	public void write(String text) throws IOException {
		bufferWriter.write(text + LocalDateTime.now());
		bufferWriter.newLine();
		bufferWriter.flush();
	}

	public void finish() throws IOException {
		bufferWriter.close();
	}
}