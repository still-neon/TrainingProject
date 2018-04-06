package by.stn.java_exercises.modul_1.ex_23_fixed;

import java.util.HashMap;
import java.util.Map;

import static by.stn.java_exercises.modul_1.ex_23_fixed.Money.BankNotes.*;

/**
 * Created by EugenKrasotkin on 4/5/2018.
 */
public class Operator {
    private static final int BASE = 100;
    private static Money preparedMoney = new Money();

    public static void getCash(Money total) {
        total.remove(preparedMoney);
    }

    public static boolean prepare(int sum) {
        prepareMoneyToRoundToBase(sum);

        prepareBaseMoney(sum - preparedMoney.getBalance());

        if (!Checker.isBankNotesEnough(preparedMoney))
            return false;
        else
            return true;
    }

    private static Result get() {
        CashMachine.getTotal().remove(preparedMoney);
        result = Result.SUCCESS;
        return result;
    }

    private static String getSuccessMessage() {
        return "The total sum " + preparedMoney.getBalance() + " was cashed out with " + preparedMoney.getNominal3Number() + " of " +
                BANKNOTE3.getNominal() + ", " + preparedMoney.getNominal2Number() + " of " + BANKNOTE2.getNominal() + ", " + preparedMoney.getNominal1Number() + " of " + BANKNOTE1.getNominal();
    }

    private static void prepareMoneyToRoundToBase(int sum) {
        switch (sum % BASE) {
            case 10:
                preparedMoney.add(BANKNOTE1, 3);
                preparedMoney.add(BANKNOTE2, 1);
                break;
            case 20:
                preparedMoney.add(BANKNOTE1, 1);
                break;
            case 30:
                preparedMoney.add(BANKNOTE1, 4);
                preparedMoney.add(BANKNOTE2, 1);
                break;
            case 40:
                preparedMoney.add(BANKNOTE1, 2);
                break;
            case 50:
                preparedMoney.add(BANKNOTE2, 1);
                break;
            case 60:
                preparedMoney.add(BANKNOTE1, 3);
                break;
            case 70:
                preparedMoney.add(BANKNOTE1, 1);
                preparedMoney.add(BANKNOTE2, 1);
                break;
            case 80:
                preparedMoney.add(BANKNOTE1, 4);
                break;
            case 90:
                preparedMoney.add(BANKNOTE1, 2);
                preparedMoney.add(BANKNOTE2, 1);
                break;
        }
    }

    private static void prepareBaseMoney(int sum) {
        Money tempTotalCopy = new Money();
        tempTotalCopy.add(CashMachine.getTotal());
        tempTotalCopy.remove(preparedMoney);

        while (sum > 0) {
            switch (checkBankNote(tempTotalCopy)) {
                case BANKNOTE1:
                    preparedMoney.add(BANKNOTE1, 5);
                    tempTotalCopy.remove(BANKNOTE1, 5);
                    break;
                case BANKNOTE2:
                    preparedMoney.add(BANKNOTE2, 2);
                    tempTotalCopy.remove(BANKNOTE2, 2);
                    break;
                case BANKNOTE3:
                    preparedMoney.add(BANKNOTE3, 1);
                    tempTotalCopy.remove(BANKNOTE3, 1);
                    break;
            }
            sum -= BASE;
        }
    }

    private static Money.BankNotes checkBankNote(Money money) {
        Map<Money.BankNotes, Integer> bankNotesForBase = new HashMap<Money.BankNotes, Integer>() {
            {
                put(BANKNOTE1, money.getNominal1Number() / (BASE / BANKNOTE1.getNominal()));
                put(BANKNOTE2, money.getNominal2Number() / (BASE / BANKNOTE2.getNominal()));
                put(BANKNOTE3, money.getNominal3Number() / (BASE / BANKNOTE3.getNominal()));
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