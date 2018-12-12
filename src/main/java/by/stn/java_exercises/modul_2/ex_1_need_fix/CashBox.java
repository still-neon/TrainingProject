package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.List;

public class CashBox {
	private int number;

	public CashBox(int number) {
		this.number = number;
	}

	public void serve(List<Goods> goods) throws InterruptedException {
		CashBoxesManager manager = CashBoxesManager.getInstance();
		Thread.sleep((long) (Math.random() * 2000));
		Printer.print(goods, number);
		manager.considerCashBox(this);
	}
}