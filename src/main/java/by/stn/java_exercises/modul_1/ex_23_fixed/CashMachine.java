package by.stn.java_exercises.modul_1.ex_23_fixed;

import lombok.Getter;

public class CashMachine {
    @Getter
    private Money total;

    public CashMachine() {
        total = new Money();
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine();
        Operator operator = new Operator();
        operator.addMoney(cashMachine, new Money(4, 2, 1));
        System.out.println(operator.getOperationDetails(operator.cashOut(cashMachine, 150)));
    }
}