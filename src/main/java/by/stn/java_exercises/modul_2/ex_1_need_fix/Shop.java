package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private static final int CUSTOMERS_LIMIT = 30;
	private static final int CASH_BOXES = 4;
	private List<CashBox> cashBoxes;
	private List<Thread> customers;//TODO: rename thread
	private Manager manager;

	public Shop() {
		cashBoxes = new ArrayList<>();
		customers = new ArrayList<>();
		manager = new Manager(cashBoxes);

		for (int i = 1; i < CASH_BOXES; i++) {
			cashBoxes.add(new CashBox(i));
		}

		for (int i = 0; i < Math.random() * CUSTOMERS_LIMIT; i++) {
			customers.add(new Thread(new Customer(GoodsListGenerator.generateGoodsList(), manager)));
			customers.get(i).start();
		}
	}
}