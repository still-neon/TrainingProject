package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.ArrayList;
import java.util.List;

public class Generator {
	private static final int GOODS_LIMIT = 6;
	private static final int CASH_BOXES_LIMIT = 4;
	private static final int CUSTOMERS_LIMIT = 35;

	public static List<Thread> generateCustomersList() {
		List<Thread> customers = new ArrayList<>();
		for (int i = 0; i < Math.random() * CUSTOMERS_LIMIT + 1; i++) {
			customers.add(new Thread(new Customer(generateGoodsList())));
		}
		return customers;
	}

	public static List<CashBox> generateCashBoxesList() {
		List<CashBox> cashBoxes = new ArrayList<>();
		for (int i = 0; i < Math.random() * CASH_BOXES_LIMIT + 1; i++) {
			cashBoxes.add(new CashBox());
		}
		return cashBoxes;
	}

	private static List<Goods> generateGoodsList() {
		List<Goods> goods = new ArrayList<>();
		for (int i = 0; i < Math.random() * GOODS_LIMIT; i++) {
			goods.add(Goods.values()[i]);
		}
		return goods;
	}
}