package by.stn.java_exercises.modul_1.ex_23_need_fix;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CashMachine {
    private static final String FAIL_STATUS1 = "There is no enough money in cash machine";
    private static final String FAIL_STATUS2 = "Impossible to cash out this sum with accessible banknotes";
    private static Money total;
    private static Money preparedMoney;

    private static String operationResult = "1";

    public CashMachine(Money money) {
        total = money;
    }

    public boolean cashOut(int money) {
        if (!Checker.isMoneyEnough(total, money)) {
            operationResult = FAIL_STATUS1;
            return false;
        }
        if (Checker.invalidValue(money)) {
            operationResult = FAIL_STATUS2;
            return false;
        }

        prepare(money);

        if (preparedMoney.getNominal1Number() <= total.getNominal1Number() && preparedMoney.getNominal2Number() <= total.getNominal2Number() &&
                preparedMoney.getNominal3Number() <= total.getNominal3Number()) {
            return true;
        } else
            return false;
    }

    private void prepare(int money) {
        Map<Money.BankNotes, Integer> bankNotesToBase = Checker.getBankNotesToBase(money);
        preparedMoney = new Money(bankNotesToBase.get(Money.BankNotes.BANKNOTE1), bankNotesToBase.get(Money.BankNotes.BANKNOTE2), bankNotesToBase.get(Money.BankNotes.BANKNOTE3));
        Money temp = new Money(total.getNominal1Number(),total.getNominal2Number(),total.getNominal3Number());
        temp.remove(preparedMoney);

        Map<Money.BankNotes, Integer> bankNotes = Checker.getBankNotes(temp, money - preparedMoney.getBalance());
        System.out.println(bankNotes);
        preparedMoney.add(new Money(bankNotes.get(Money.BankNotes.BANKNOTE1), bankNotes.get(Money.BankNotes.BANKNOTE2), bankNotes.get(Money.BankNotes.BANKNOTE3)));
    }

    public void addMoney(Money money) {
        total.add(money);
    }

    private static void printOperationResult(boolean result) {
        if (result) {
            System.out.println("The total sum " + preparedMoney.getBalance() + " was preparedMoney with " + preparedMoney.getNominal3Number() + " of " + Money.BankNotes.BANKNOTE3.getNominal() +
                    ", " + preparedMoney.getNominal2Number() + " of " + Money.BankNotes.BANKNOTE2.getNominal() + ", " + preparedMoney.getNominal1Number() + " of " + Money.BankNotes.BANKNOTE1.getNominal());
        } else {
            System.out.println(operationResult);
        }
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine(new Money(6, 5, 5));
        printOperationResult(cashMachine.cashOut(100));
    }
}