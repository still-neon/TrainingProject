package by.stn.java_exercises.modul_2.ex_1;

public class Shop {
	private static final int CUSTOMERS_LIMIT = 30;

	public static void init() {
		for (int i = 0; i < Math.random() * CUSTOMERS_LIMIT; i++) {
			new Thread(new Customer(GoodsListGenerator.generateGoodsList())).start();
		}
	}
}