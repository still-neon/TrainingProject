package by.stn.java_exercises.modul_2.ex_1;

/**
 * Created by EugenKrasotkin on 3/29/2018.
 */
public class Cashbox {
    private static final int CUSTOMERS_MAX_NUMBER = 5;

    public void printGoods(Customer customer) {
        System.out.println(customer.getGoods());
    }
}