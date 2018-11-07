package by.stn.java_exercises.modul_2.ex_1_need_fix;

import by.stn.trainingproject.archiver.Generator;

import java.util.List;

public class Shop {
    private List<CashBox> cashBoxes;
    private List<Thread> customers;//кастомеры это потоки, ломятся в кассы, лочат кассу, Lock синхронизация
    private static Shop instance;

    public Shop() {
        customers = Generator.generateCustomersList();
        cashBoxes = Generator.generateCashBoxesList();
        System.out.println("Customers: "+ customers.size());
        System.out.println("CashBoxes: "+ cashBoxes.size());
    }

    public static synchronized Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    public void serve(Customer customer) {
        while(!customer.isServed()) {
            for (CashBox cashBox : cashBoxes) {
                cashBox.serve(customer);
                if(customer.isServed())
                    break;
            }
        }
    }

    public void manage() {
        for(Thread customer: customers) {
            customer.start();
        }
    }
}