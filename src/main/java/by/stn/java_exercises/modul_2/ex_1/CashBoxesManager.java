package by.stn.java_exercises.modul_2.ex_1;

import java.util.ArrayDeque;
import java.util.Queue;

public class CashBoxesManager {
	private static final int CASH_BOXES = 4;
	private Queue<CashBox> cashBoxes;
	private static CashBoxesManager instance;

	private CashBoxesManager() {
		cashBoxes = new ArrayDeque<>();
		for (int i = 1; i < CASH_BOXES; i++) {
			cashBoxes.offer(new CashBox(i));
		}
	}

	public static synchronized CashBoxesManager getInstance() {
		if (instance == null) {
			instance = new CashBoxesManager();
		}
		return instance;
	}

	public synchronized CashBox getFreeCashBox() {
		return cashBoxes.poll();
	}

	public synchronized void considerCashBox(CashBox cashBox) {
		cashBoxes.offer(cashBox);
		notifyCustomers();
	}

	private synchronized void notifyCustomers() {
		notifyAll();
	}
}