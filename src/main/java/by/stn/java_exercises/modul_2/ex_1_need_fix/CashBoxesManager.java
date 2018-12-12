package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

import java.util.Queue;

public class CashBoxesManager {
	@Getter
	private static CashBoxesManager instance;
	private Queue<CashBox> cashBoxes;

	private CashBoxesManager(Queue<CashBox> cashBoxes) {
		this.cashBoxes = cashBoxes;
	}

	public static synchronized CashBoxesManager getInstance(Queue<CashBox> cashBoxes) {
		if (instance == null) {
			instance = new CashBoxesManager(cashBoxes);
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
}