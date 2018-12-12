package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

import java.util.List;

public class Customer implements Runnable {
	@Getter
	private List<Goods> goods;

	public Customer(List<Goods> goods) {
		this.goods = goods;
	}

	@Override
	public void run() {
		CashBoxesManager manager = CashBoxesManager.getInstance();
		CashBox freeCashBox = manager.getFreeCashBox();
		try {
			while (freeCashBox == null) {
				synchronized (manager) {
					manager.wait();
				}
				freeCashBox = manager.getFreeCashBox();
			}
			freeCashBox.serve(this.goods);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}