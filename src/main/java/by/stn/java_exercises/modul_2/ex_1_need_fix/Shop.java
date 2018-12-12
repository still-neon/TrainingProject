package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Shop {
	private static final int CUSTOMERS_LIMIT = 30;
	private static final int CASH_BOXES = 4;
	private Queue<CashBox> cashBoxes;
	private List<Thread> threads;

	public Shop() {
		cashBoxes = new ArrayDeque<>();
		threads = new ArrayList<>();
		CashBoxesManager.getInstance(cashBoxes);
	}

	public void start() {
		for (int i = 1; i < CASH_BOXES; i++) {
			cashBoxes.offer(new CashBox(i));
		}

		for (int i = 0; i < Math.random() * CUSTOMERS_LIMIT; i++) {
			threads.add(new Thread(new Customer(GoodsListGenerator.generateGoodsList())));
			threads.get(i).start();
		}
	}
}