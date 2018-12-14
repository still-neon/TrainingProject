package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private static final int CUSTOMERS_LIMIT = 30;

	public static void init() {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < Math.random() * CUSTOMERS_LIMIT; i++) {
			threads.add(new Thread(new Customer(GoodsListGenerator.generateGoodsList())));
			threads.get(i).start();
		}
	}
}