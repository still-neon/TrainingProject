package by.stn.java_exercises.modul_1.ex_23_fixed;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static by.stn.java_exercises.modul_1.ex_23_fixed.Money.BankNotes.*;

/**
 * Created by EugenKrasotkin on 4/3/2018.
 */
public class Validator {
    @Getter
    private static final String MONEY_CASHED_OUT = "Ok";
    @Getter
    private static final String NOT_ENOUGH_BANKNOTES = "Impossible to cash out this sum with accessible banknotes.";
    @Getter
    private static final String NOT_ENOUGH_MONEY = "There is no enough money in cash machine.";
    @Getter
    private static final String INVALID_SUM = "The sum is invalid. Try another value.";
    private static final int HUNDRED = 100;
    private Money prepared;
    private Money available;

    public Validator(Money available) {
        prepared = new Money();
        this.available = available;
    }

    public OperationResult tryCashOut(int sum) {
        if (!isMoneyEnough(sum))
            return new OperationResult(Result.NOT_ENOUGH_MONEY_FAIL);
        else if (!isSumValid(sum))
            return new OperationResult(Result.INVALID_SUM_FAIL);
        else if (!isPrepared(sum))
            return new OperationResult(Result.NOT_ENOUGH_BANKNOTES_FAIL);
        else
            return new OperationResult(Result.SUCCESS, prepared);
    }

    private boolean isPrepared(int sum) {
        prepareMoneyToRoundToBase(prepared, sum);

        prepareBaseMoney(available, prepared, sum - prepared.getBalance());

        return isBankNotesEnough(available);
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
                put(BANKNOTE1, money.getNominal1Number() / 5);
                put(BANKNOTE2, money.getNominal2Number() / 2);
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

    private boolean isBankNotesEnough(Money money) {
        return money.getNominal1Number() >= 0 && money.getNominal2Number() >= 0 && money.getNominal3Number() >= 0;
    }

    private boolean isMoneyEnough(int sum) {
        return available.getBalance() > sum;
    }

    private boolean isSumValid(int sum) {
        return sum % Money.getBASE() == 0 && sum != Money.getINVALID_VALUE1() && sum != Money.getINVALID_VALUE2();
    }

    public enum Result {
        SUCCESS(MONEY_CASHED_OUT, true), NOT_ENOUGH_MONEY_FAIL(NOT_ENOUGH_MONEY, false), INVALID_SUM_FAIL(INVALID_SUM, false), NOT_ENOUGH_BANKNOTES_FAIL(NOT_ENOUGH_BANKNOTES, false);
        @Getter
        private String message;
        @Getter
        private boolean isSuccess;

        Result(String message, boolean isSuccess) {
            this.message = message;
            this.isSuccess = isSuccess;
        }
    }
}