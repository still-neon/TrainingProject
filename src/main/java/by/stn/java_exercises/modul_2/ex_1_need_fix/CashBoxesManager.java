package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.ArrayDeque;
import java.util.Queue;

public class CashBoxesManager {
	private static final int CASH_BOXES = 4;
	private Queue<CashBox> cashBoxes;
	private static CashBoxesManager instance;

	private CashBoxesManager() {
		cashBoxes = new ArrayDeque<>();
		init();
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

	public void considerCashBox(CashBox cashBox) {
		cashBoxes.offer(cashBox);
		notifyCustomers();
	}

	private synchronized void notifyCustomers() {
		notifyAll();
	}

	private void init() {
		for (int i = 1; i < CASH_BOXES; i++) {
			cashBoxes.offer(new CashBox(i));
		}
	}
}