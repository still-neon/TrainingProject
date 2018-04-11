package by.stn.java_exercises.modul_1.ex_23_fixed;

import lombok.Getter;
import lombok.Setter;

import static by.stn.java_exercises.modul_1.ex_23_fixed.Money.BankNotes.*;

/**
 * Created by EugenKrasotkin on 4/10/2018.
 */
public class Result {
    @Getter
    private static final String MONEY_CASHED_OUT = "Ok";
    @Getter
    private static final String NOT_ENOUGH_BANKNOTES = "Impossible to cash out this sum with accessible banknotes.";
    @Getter
    private static final String NOT_ENOUGH_MONEY = "There is no enough money in cash machine.";
    @Getter
    private static final String INVALID_SUM = "The sum is invalid. Try another value.";
    @Getter
    @Setter
    private ValidationResult validationResult;
    @Getter
    private int nominal1Number;
    @Getter
    private int nominal2Number;
    @Getter
    private int nominal3Number;

    public void setPreparedNumbers(Money prepared) {
        nominal1Number = prepared.getNominal1Number();
        nominal2Number = prepared.getNominal2Number();
        nominal3Number = prepared.getNominal3Number();
    }

    public String getOperationDetails() {
        return validationResult.isSuccess ? "The sum was cashed out with " + nominal3Number + " of " + BANKNOTE3.getNominal() + ", " + nominal2Number + " of " + BANKNOTE2.getNominal() + ", " +
                nominal1Number + " of " + BANKNOTE1.getNominal() : validationResult.getMessage();
    }

    public enum ValidationResult {
        SUCCESS(MONEY_CASHED_OUT, true), NOT_ENOUGH_MONEY_FAIL(NOT_ENOUGH_MONEY, false), INVALID_SUM_FAIL(INVALID_SUM, false), NOT_ENOUGH_BANKNOTES_FAIL(NOT_ENOUGH_BANKNOTES, false);
        @Getter
        private String message;
        @Getter
        private boolean isSuccess;

        ValidationResult(String message, boolean isSuccess) {
            this.message = message;
            this.isSuccess = isSuccess;
        }
    }
}