package by.stn.java_exercises.modul_2.ex_1_fixed;

/**
 * Created by EugenKrasotkin on 3/29/2018.
 */
public class Cashbox {
    public void printGoods(Customer customer) {
        for(Goods good: customer.getGoods())
        System.out.println(good.getName());
    }
}