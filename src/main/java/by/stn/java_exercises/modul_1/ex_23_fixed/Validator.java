package by.stn.java_exercises.modul_1.ex_23_fixed;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static by.stn.java_exercises.modul_1.ex_23_fixed.Money.BankNotes.BANKNOTE1;
import static by.stn.java_exercises.modul_1.ex_23_fixed.Money.BankNotes.BANKNOTE2;
import static by.stn.java_exercises.modul_1.ex_23_fixed.Money.BankNotes.BANKNOTE3;

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

    public Result tryCashOut(Money available, Money prepared, int sum) {
        Result result = Result.SUCCESS;
        if (!isMoneyEnough(available, sum)) {
            result = Result.NOT_ENOUGH_MONEY_FAIL;
        }
        if (!isSumValid(sum)) {
            result = Result.INVALID_SUM_FAIL;
        }
        if (!isSumPrepared(available, prepared, sum)) {
            result = Result.NOT_ENOUGH_BANKNOTES_FAIL;
        }
        return result;
    }

    public Validator.Result cashOut(int sum) {
        Validator.Result result = Validator.tryCashOut(available, prepared, sum);

        if (result.isSuccess()) {
            cashMachine.getTotal().remove(prepared);
        }

        return result;
    }

    public static boolean isPrepared(Money totalCopy, Money prepared, int sum) {
        prepareMoneyToRoundToBase(prepared, sum);

        prepareBaseMoney(totalCopy, prepared, sum - prepared.getBalance());

        return Validator.isBankNotesEnough(totalCopy);
    }

    public String getOperationDetails(Validator.Result result) {
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


    public static boolean isBankNotesEnough(Money money) {
        return money.getNominal1Number() >= 0 && money.getNominal2Number() >= 0 && money.getNominal3Number() >= 0;
    }

    private static boolean isSumPrepared(Money totalCopy, Money prepared, int sum) {
        return Operator.isPrepared(totalCopy, prepared, sum);
    }

    private static boolean isMoneyEnough(Money money, int sum) {
        return money.getBalance() > sum;
    }

    private static boolean isSumValid(int sum) {
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