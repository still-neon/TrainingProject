package by.stn.java_exercises.modul_2.ex_1_need_fix;

import lombok.Getter;

public class CashBox {
	@Getter
	private boolean free;
	private int number = (int) (Math.random() * 9999); /*//чисто для проверки какая касса обслуживает, потом удалю*/

	public CashBox() {
		unlock();
	}

	public synchronized void serve(Customer customer) {
		//lock(); пока не доделал реализацию
		System.out.println("CashBox number " + number + " Customers goods are:");
		for (Goods good : customer.getGoods()) {
			System.out.println(good.getName());
		}
		customer.makeServed();
		//unlock();
	}

	private void lock() {
		free = false;
	}

	private void unlock() {
		free = true;
	}
}