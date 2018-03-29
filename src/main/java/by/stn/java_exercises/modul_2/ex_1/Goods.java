package by.stn.java_exercises.modul_2.ex_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/29/2018.
 */
public enum Goods {
    BREAD("Bread"), MILK("Milk"), COFFEE("Coffee"), WHATER("Whater"), BEER("Beer"), MEAT("Meat");

    private String name;

    Goods(String name) {
        this.name = name;
    }

    public static List<String> generateGoods() {
        List<String> goods = new ArrayList<>();
        for (int i = 0; i < Math.random() * 6 + 1; i++) {
            goods.add(String.valueOf(Goods.values()[i].name));
        }
        return goods;
    }
}
