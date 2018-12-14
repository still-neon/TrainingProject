package by.stn.java_exercises.modul_2.ex_5_review;

import java.util.Locale;
import java.util.ResourceBundle;

public class Saluter {
	public static final String RESOURCE_NAME = "Greeting";
	public static final String SALUTE_ID = "greetings";
	private ResourceBundle rs;

	public Saluter(String language, String country) {
		init(new Locale(language, country));
	}

	public Saluter() {
		init(Locale.ENGLISH);
	}

	private void init(Locale locale) {
		rs = ResourceBundle.getBundle(RESOURCE_NAME, locale);
	}

	private String getSalute() {
		return rs.getString(SALUTE_ID);
	}

	public static void main(String args[]) {
		System.out.println(new Saluter("ru", "RU").getSalute());
		System.out.println(new Saluter().getSalute());
	}
}