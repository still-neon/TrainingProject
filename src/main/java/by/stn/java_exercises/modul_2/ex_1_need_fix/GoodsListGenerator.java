package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.ArrayList;
import java.util.List;


public class GoodsListGenerator {
	private static final int GOODS_LIMIT = 10;

	public static List<Goods> generateGoodsList() {
		List<Goods> goods = new ArrayList<>();
		for (int i = 0; i < Math.random() * GOODS_LIMIT; i++) {
			goods.add(Goods.values()[(int) (Math.random() * Goods.values().length)]);
		}
		return goods;
	}
}