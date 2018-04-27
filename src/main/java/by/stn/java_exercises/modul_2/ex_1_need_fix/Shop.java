package by.stn.java_exercises.modul_2.ex_1_need_fix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/29/2018.
 */
public class Shop {
    private static final int CASH_DESKS = 6;
    private static final int MAX_CUSTOMERS_NUMBER = 10;
    private List<Customer> customers;//кастомеры это потоки, ломятся в кассы, лочат кассу, Lock синхронизация

    public Shop() {
        customers = new ArrayList<>();
        for (int i = 0; i < Math.random() * MAX_CUSTOMERS_NUMBER + 1; i++) {
            customers.add(new Customer());
        }
    }

    public void manage() {
        int customersNumber = customers.size();

        while (customersNumber > 0) {
            if (customersNumber > CASH_DESKS) {
                for (int i = 0; i < CASH_DESKS; i++) {
                    new Thread(customers.get(i)).start();
                    customersNumber--;
                }
            } else {
                for (int i = 0; i < customersNumber; i++) {
                    new Thread(customers.get(i)).start();
                    customersNumber--;
                }
            }
        }
    }
}