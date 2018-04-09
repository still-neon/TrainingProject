package by.stn.java_exercises.modul_1.ex_23_fixed;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 4/3/2018.
 */
public class Checker {
    @Getter
    private static final String MONEY_CASHED_OUT = "Ok";
    @Getter
    private static final String NOT_ENOUGH_BANKNOTES = "Impossible to cash out this sum with accessible banknotes.";
    @Getter
    private static final String NOT_ENOUGH_MONEY = "There is no enough money in cash machine.";
    @Getter
    private static final String INVALID_SUM = "The sum is invalid. Try another value.";

    public static Result getPreparationResult(CashMachine cashMachine, Money prepared, int sum) {
        Money totalCopy = cashMachine.getTotal().clone();

        Result result = Result.SUCCESS;
        if (!isMoneyEnough(totalCopy, sum)) {
            result = Result.NOT_ENOUGH_MONEY_FAIL;
        }
        if (!isSumValid(sum)) {
            result = Result.INVALID_SUM_FAIL;
        }
        if (!isSumPrepared(totalCopy, prepared, sum)) {
            result = Result.NOT_ENOUGH_BANKNOTES_FAIL;
        }
        return result;
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