package by.stn.java_exercises.modul_3.dog_door;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;

public class Test extends Observable {

	public static void main(String args[]) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.print(new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime()));
	}
}