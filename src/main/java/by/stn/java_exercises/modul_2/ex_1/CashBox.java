package by.stn.java_exercises.modul_2.ex_1;

import java.util.List;

public class CashBox {
	private int number;

	public CashBox(int number) {
		this.number = number;
	}

	public void serve(List<Goods> goods) throws InterruptedException {
		Thread.sleep((long) (Math.random() * 2000));
		Printer.print(goods, number);
		CashBoxesManager.getInstance().considerCashBox(this);
	}
}