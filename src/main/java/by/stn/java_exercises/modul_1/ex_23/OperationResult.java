package by.stn.java_exercises.modul_1.ex_23;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static by.stn.java_exercises.modul_1.ex_23.Money.BankNotes.*;

/**
 * Created by EugenKrasotkin on 4/10/2018.
 */
@AllArgsConstructor
public class OperationResult {
    private Validator.Result result;
    @Getter
    private Money money;

    public OperationResult(Validator.Result result) {
        this.result = result;
    }

    public String getOperationDetails() {
        return isSuccess() ? "The sum " + money.getBalance() + " was cashed out with " + money.getNominal3Number() + " of " + BANKNOTE3.getNominal() + ", " + money.getNominal2Number() + " of " + BANKNOTE2.getNominal() + ", " +
                money.getNominal1Number() + " of " + BANKNOTE1.getNominal() : result.getMessage();
    }

    public boolean isSuccess() {
        return result.isSuccess();

    }
}