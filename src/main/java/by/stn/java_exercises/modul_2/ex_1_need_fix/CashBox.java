package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

import java.util.List;

public class CashBox {
	@Getter
	private boolean free;
	private int number;
	private CashBoxesManager manager;

	public CashBox(int number, CashBoxesManager manager) {
		this.number = number;
		this.manager = manager;
		unlock();
	}

	public void serve(List<Goods> goods) throws InterruptedException {
		Thread.sleep((long) (Math.random() * 2000));
		Printer.print(goods, number);
		manager.openCashBox(this);
	}

	public void lock() {
		free = false;
	}

	public void unlock() {
		free = true;
	}
}