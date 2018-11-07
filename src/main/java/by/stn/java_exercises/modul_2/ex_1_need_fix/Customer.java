package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

import java.util.List;

public class Customer implements Runnable {
	@Getter
	private List<Goods> goods;
	@Getter
	private boolean served;

	public Customer(List<Goods> goods) {
		this.goods = goods;
	}

	@Override
	public void run() {
		buy();
	}

	private void buy() {
		Shop.getInstance().serve(this);
	}

	public void makeServed() {
		served = true;
	}
}