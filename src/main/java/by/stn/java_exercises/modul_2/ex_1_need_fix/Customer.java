package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

import java.util.List;

public class Customer implements Runnable {
	@Getter
	private List<Goods> goods;
	private CashBoxesManager manager;
	private CashBox freeCashBox;

	public Customer(List<Goods> goods, CashBoxesManager manager) {
		this.goods = goods;
		this.manager = manager;
	}

	@Override
	public void run() {
		freeCashBox = manager.getFreeCashBox();
		try {
			while (freeCashBox == null) {
				synchronized (manager) {
					manager.wait();
				}
				freeCashBox = manager.getFreeCashBox();
			}
			freeCashBox.serve(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}