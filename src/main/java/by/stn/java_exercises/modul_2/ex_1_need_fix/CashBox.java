package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

public class CashBox {
	@Getter
	private boolean free;
	private int number;
	private Manager manager;

	public CashBox(int number, Manager manager) {
		this.number = number;
		this.manager = manager;
		unlock();
	}

	public void serve(Customer customer) throws InterruptedException {
		Thread.sleep(1000);
		Printer.print(customer.getGoods(), number);
		unlock();
		manager.notify();
	}

	public void lock() {
		free = false;
	}

	public void unlock() {
		free = true;
	}
}