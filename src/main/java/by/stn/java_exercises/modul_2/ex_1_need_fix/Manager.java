package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.List;

public class Manager {
	private CashBox freeCashBox;
	private List<CashBox> cashBoxes;

	public Manager(List<CashBox> cashBoxes) {
		this.cashBoxes = cashBoxes;
	}

	public void manage(Customer customer) {//TODO: move to customer, монитор, wait notify
		while (!customer.isServed()) {
			freeCashBox = getFreeCashBox();
			if (freeCashBox != null) {
				freeCashBox.serve(customer);
			}
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