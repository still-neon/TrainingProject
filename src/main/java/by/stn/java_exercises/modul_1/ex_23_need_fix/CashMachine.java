package by.stn.java_exercises.modul_1.ex_23_need_fix;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CashMachine {//деньги отдельным классом представление//не поля класса
    private Money total;
    private Money cashed;

    public CashMachine(Money money) {
        total = money;
    }

    public void addMoney(Money money) {
        total.add(money);
    }

    private boolean getCash(int moneyToGet) {
        cashed = new Money(0, 0, 0);
        Map<Integer, Integer> bankNotes = new TreeMap<Integer, Integer>(Collections.reverseOrder()) {//косяк сравнивать возможность с загрузкой банкомата
            {
                put(total.getBANKNOTE_NOMINAL_1(), total.getBankNotes1Number());
                put(total.getBANKNOTE_NOMINAL_2(), total.getBankNotes2Number());
                put(total.getBANKNOTE_NOMINAL_3(), total.getBankNotes3Number());
            }
        };

        do {
            for (Map.Entry<Integer, Integer> bankNote : bankNotes.entrySet()) {
                if (isPossibleToGet(moneyToGet, bankNote.getKey(), bankNote.getValue())) {
                    cashed.add(bankNote.getKey());
                    moneyToGet -= bankNote.getKey();
                    System.out.println(moneyToGet + " - " + bankNote.getKey());
                }
            }
        } while (moneyToGet >= total.getBANKNOTE_NOMINAL_1());
        return moneyToGet == 0;
    }

    private boolean isPossibleToGet(int money, int bankNote, int bankNoteNumber) {
        return money >= bankNote && bankNoteNumber > 0;
    }

    private boolean notEnoughMoney(int money) {
        return money > total.getBalance();
    }

    public boolean cashOut(int money) {
        if (notEnoughMoney(money)) {
            System.out.println("There is no enough money in cash machine");
            return false;
        }

        if (getCash(money)) {
            System.out.println("The total sum " + cashed.getBalance() + " was cashed with " + cashed.getBankNotes3Number() + " of " + cashed.getBANKNOTE_NOMINAL_3() +
                    ", " + cashed.getBankNotes2Number() + " of " + cashed.getBANKNOTE_NOMINAL_2() + ", " + cashed.getBankNotes1Number() + " of " + cashed.getBANKNOTE_NOMINAL_1());
            return true;
        } else {
            System.out.println("Check another sum");
            return false;
        }
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine(new Money(6, 5, 5));
        cashMachine.cashOut(150);
    }
}