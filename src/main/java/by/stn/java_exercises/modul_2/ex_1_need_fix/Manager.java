package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.List;

public class Manager {
	private CashBox freeCashBox;
	private List<CashBox> cashBoxes;

	public Manager(List<CashBox> cashBoxes) {
		this.cashBoxes = cashBoxes;
	}

	public void manage(Customer customer) {
		synchronized (this) {
			while (getFreeCashBox() == null) {
			}
		}
		try {
			getFreeCashBox().serve(customer);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized CashBox getFreeCashBox() {
		for (CashBox cashBox : cashBoxes) {
			if (cashBox.isFree()) {
				return cashBox;
			}
		}
		return null;
	}
}