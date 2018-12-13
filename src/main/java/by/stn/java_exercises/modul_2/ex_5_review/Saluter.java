package by.stn.java_exercises.modul_2.ex_5_review;

import java.util.Locale;
import java.util.ResourceBundle;

public class Saluter {
	public static final String RESOURCE_NAME = "Greeting";
	public static final String SALUTE_ID = "greetings";
	private ResourceBundle rs;

	public Saluter(String language, String country) {
		rs = getResourceBundle(new Locale(language, country));
	}

	public Saluter() {
		rs = getResourceBundle(Locale.ENGLISH);
	}

	public static void main(String args[]) {
		System.out.println(new Saluter("ru", "RU").getSalute());
		System.out.println(new Saluter().getSalute());
	}

	private ResourceBundle getResourceBundle(Locale locale) {
		return ResourceBundle.getBundle(RESOURCE_NAME, locale);
	}

	private String getSalute() {
		return rs.getString(SALUTE_ID);
	}
}