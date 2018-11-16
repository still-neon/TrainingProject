package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

import java.util.List;

public class Customer implements Runnable {
	@Getter
	private List<Goods> goods;
	@Getter
	private boolean served;
	private Manager manager;

	public Customer(List<Goods> goods, Manager manager) {
		this.goods = goods;
		this.manager = manager;
	}

	@Override
	public void run() {
		if (manager.getFreeCashBox() != null) {
			manager.getFreeCashBox().serve(this);
		} else

			manager.manage(this);
	}

	public void becomeServed() {
		served = true;
	}
}