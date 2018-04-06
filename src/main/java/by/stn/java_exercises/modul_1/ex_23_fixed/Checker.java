package by.stn.java_exercises.modul_1.ex_23_fixed;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 4/3/2018.
 */
public class Checker {
    @Getter
    private static final String NOT_ENOUGH_BANKNOTES = "Impossible to cash out this sum with accessible banknotes.";
    @Getter
    private static final String NOT_ENOUGH_MONEY = "There is no enough money in cash machine.";
    @Getter
    private static final String INVALID_SUM = "The sum is invalid. Try another value.";

    public static Result isCashReady(Money total, int sum) {
        Money totalCopy = total.clone();

        Result result;
        if (!isMoneyEnough(totalCopy, sum)) {
            result = Result.NOT_ENOUGH_MONEY_FAIL;
        }
        if (!isSumValid(sum)) {
            result = Result.INVALID_SUM_FAIL;
        }
        if (!isSumPrepared(sum)) {
            result = Result.NOT_ENOUGH_BANKNOTES_FAIL;
        }
        result = Result.SUCCESS;
        return result;
    }

    public static boolean isBankNotesEnough(Money preparedMoney) {
        if (preparedMoney.getNominal1Number() > CashMachine.getTotal().getNominal1Number() || preparedMoney.getNominal2Number() > CashMachine.getTotal().getNominal2Number() ||
                preparedMoney.getNominal3Number() > CashMachine.getTotal().getNominal3Number()) {
            return false;
        } else
            return true;
    }

    private static boolean isSumPrepared(int sum) {
        return Operator.prepare(sum);
    }

    private static boolean isMoneyEnough(Money money, int sum) {
        return money.getBalance() > sum;
    }

    private static boolean isSumValid(int sum) {
        return sum % Money.getBASE() == 0 && sum != Money.getINVALID_VALUE1() && sum != Money.getINVALID_VALUE2();
    }

    public enum Result {
        SUCCESS("getSuccessMessage()", true), NOT_ENOUGH_MONEY_FAIL(NOT_ENOUGH_MONEY, false), INVALID_SUM_FAIL(INVALID_SUM, false), NOT_ENOUGH_BANKNOTES_FAIL(NOT_ENOUGH_BANKNOTES, false);
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