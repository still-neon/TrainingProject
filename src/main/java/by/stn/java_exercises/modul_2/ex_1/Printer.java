package by.stn.java_exercises.modul_2.ex_1;

import java.util.List;

public class Printer {
	public static void print(List<Goods> goods, int number) {
		StringBuilder goodsList = new StringBuilder();
		for (Goods good : goods) {
			goodsList.append(" ".concat(good.getName()));
		}
		System.out.println("CashBox " + number + " serve goods:" + goodsList);
	}
}