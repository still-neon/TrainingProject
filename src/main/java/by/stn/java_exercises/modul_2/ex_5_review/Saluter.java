package by.stn.java_exercises.modul_2.ex_5_review;

import java.util.Locale;
import java.util.ResourceBundle;

public class Saluter {
	public static final String RESOURCE_NAME = "Greeting";
	public static final String SALUTE_ID = "greetings";
	private Locale locale;

	public Saluter(String language, String country) {
		locale = new Locale(language, country);
	}

	public Saluter() {
		locale = Locale.ENGLISH;
	}

	public static void main(String args[]) {
		System.out.println(new Saluter("ru", "RU").getSalute());
		System.out.println(new Saluter().getSalute());
	}

	private String getSalute() {
		return ResourceBundle.getBundle(RESOURCE_NAME, locale).getString(SALUTE_ID);
	}
}