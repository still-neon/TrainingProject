package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.List;

public class Printer {
	public static synchronized void print(List<Goods> goods, int number) {
		System.out.println("CashBox number " + number + " Customer goods are:");
		for (Goods good : goods) {
			System.out.println(good.getName());
		}
	}
}