package by.stn.java_exercises.modul_2.ex_1_fixed;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/29/2018.
 */
public class Customer implements Runnable {
    private static final int MAX_GOODS_NUMBER = 6;
    @Getter
    private List<Goods> goods;

    public Customer() {
        goods = new ArrayList<>();
        for (int i = 0; i < Math.random() * MAX_GOODS_NUMBER + 1; i++) {
            goods.add(Goods.values()[i]);
        }
    }

    @Override
    public void run() {
        printGoods();
    }

    private void printGoods() {
        System.out.println("Customer's goods are:");
        for (Goods good : goods) {
            System.out.println(good.getName());
        }
    }
}