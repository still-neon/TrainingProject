package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.List;

public class CashBoxesManager {
	private List<CashBox> cashBoxes;

	public CashBoxesManager(List<CashBox> cashBoxes) {
		this.cashBoxes = cashBoxes;
	}

	public synchronized CashBox getFreeCashBox() {
		for (CashBox cashBox : cashBoxes) {
			if (cashBox.isFree()) {
				cashBox.lock();
				return cashBox;
			}
		}
		return null;
	}

	public void openCashBox(CashBox cashBox) {
		cashBox.unlock();
		notifyCustomers();
	}

	private synchronized void notifyCustomers() {
		notifyAll();
	}
}