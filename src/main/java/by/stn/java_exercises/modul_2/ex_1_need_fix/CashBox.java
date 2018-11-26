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

	public synchronized void serve(Customer customer) throws InterruptedException {
		while (!isFree()) {
			customer.wait();
		}
		lock();
		Thread.sleep(1000);
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