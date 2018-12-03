package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.List;

public class Manager {
	private CashBox freeCashBox;
	private List<CashBox> cashBoxes;

	public Manager(List<CashBox> cashBoxes) {
		this.cashBoxes = cashBoxes;
	}

	public void manage(Customer customer) throws InterruptedException {
//		synchronized (this) {
//			if (getFreeCashBox() == null) {
//				customer.wait();
//			}
//		}
		getFreeCashBox().serve(customer);
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