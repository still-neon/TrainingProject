package by.stn.java_exercises.modul_2.ex_5_review;

import java.util.Locale;
import java.util.ResourceBundle;

public class Saluter {
	public static final String RESOURCE_NAME = "Greeting";
	public static final String SALUTE_ID = "greetings";
	public static final String DEFAULT_LANGUAGE = "en";
	public static final String DEFAULT_COUNTRY = "US";

	private static String getSalute(String language, String country) {
		return ResourceBundle.getBundle(RESOURCE_NAME, new Locale(language, country)).getString(SALUTE_ID);
	}

	private static String getSalute() {
		return ResourceBundle.getBundle(RESOURCE_NAME, new Locale(DEFAULT_LANGUAGE, DEFAULT_COUNTRY)).getString(SALUTE_ID);
	}

	public static void main(String args[]) {
		System.out.println(getSalute("ru", "RU"));
		System.out.println(getSalute());
	}
}