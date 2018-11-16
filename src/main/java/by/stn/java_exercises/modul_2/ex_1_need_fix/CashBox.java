package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

public class CashBox {
	@Getter
	private boolean free;
	private int number;

	public CashBox(int number) {
		this.number = number;
		unlock();
	}

	public synchronized void serve(Customer customer) {
		lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Printer.print(customer.getGoods(), number);
		unlock();
		notifyAll();
	}

	private void lock() {
		free = false;
	}

	private void unlock() {
		free = true;
	}
}