package by.stn.java_exercises.modul_1.ex_23_fixed;

import java.util.HashMap;
import java.util.Map;

import static by.stn.java_exercises.modul_1.ex_23_fixed.Money.BankNotes.*;

/**
 * Created by EugenKrasotkin on 4/5/2018.
 */
public class Operator {
    private static final int HUNDRED = 100;
    private Money prepared;

    public Operator() {
        prepared = new Money();
    }

    public void addMoney(CashMachine cashMachine, Money money) {
        cashMachine.getTotal().add(money);
    }

    public Checker.Result cashOut(CashMachine cashMachine, int sum) {
        Checker.Result result = Checker.getPreparationResult(cashMachine, prepared, sum);

        if (result.isSuccess()) {
            cashMachine.getTotal().remove(prepared);
        }

        return result;
    }

    public static boolean isPrepared(Money totalCopy, Money prepared, int sum) {
        prepareMoneyToRoundToBase(prepared, sum);

        prepareBaseMoney(totalCopy, prepared, sum - prepared.getBalance());

        return Checker.isBankNotesEnough(totalCopy);
    }

    public String getOperationDetails(Checker.Result result) {
        return result.isSuccess() ? "The total sum " + prepared.getBalance() + " was cashed out with " + prepared.getNominal3Number() + " of " +
                BANKNOTE3.getNominal() + ", " + prepared.getNominal2Number() + " of " + BANKNOTE2.getNominal() + ", " + prepared.getNominal1Number() + " of " + BANKNOTE1.getNominal() : result.getMessage();
    }

    private static void prepareMoneyToRoundToBase(Money prepared, int sum) {
        switch (sum % HUNDRED) {
            case 10:
                prepared.add(BANKNOTE1, 3);
                prepared.add(BANKNOTE2, 1);
                break;
            case 20:
                prepared.add(BANKNOTE1, 1);
                break;
            case 30:
                prepared.add(BANKNOTE1, 4);
                prepared.add(BANKNOTE2, 1);
                break;
            case 40:
                prepared.add(BANKNOTE1, 2);
                break;
            case 50:
                prepared.add(BANKNOTE2, 1);
                break;
            case 60:
                prepared.add(BANKNOTE1, 3);
                break;
            case 70:
                prepared.add(BANKNOTE1, 1);
                prepared.add(BANKNOTE2, 1);
                break;
            case 80:
                prepared.add(BANKNOTE1, 4);
                break;
            case 90:
                prepared.add(BANKNOTE1, 2);
                prepared.add(BANKNOTE2, 1);
                break;
        }
    }

    private static void prepareBaseMoney(Money totalCopy, Money prepared, int sum) {
        totalCopy.remove(prepared);

        while (sum > 0) {
            switch (checkBankNote(totalCopy)) {
                case BANKNOTE1:
                    prepared.add(BANKNOTE1, 5);
                    totalCopy.remove(BANKNOTE1, 5);
                    break;
                case BANKNOTE2:
                    prepared.add(BANKNOTE2, 2);
                    totalCopy.remove(BANKNOTE2, 2);
                    break;
                case BANKNOTE3:
                    prepared.add(BANKNOTE3, 1);
                    totalCopy.remove(BANKNOTE3, 1);
                    break;
            }
            sum -= HUNDRED;
        }
    }

    private static Money.BankNotes checkBankNote(Money money) {
        Map<Money.BankNotes, Integer> bankNotesForBase = new HashMap<Money.BankNotes, Integer>() {
            {
                put(BANKNOTE1, money.getNominal1Number());
                put(BANKNOTE2, money.getNominal2Number());
                put(BANKNOTE3, money.getNominal3Number());
            }
        };

        int max = 0;
        Money.BankNotes bankNote = null;

        for (Map.Entry<Money.BankNotes, Integer> entry : bankNotesForBase.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                bankNote = entry.getKey();
            }
        }
        return bankNote;
    }
}