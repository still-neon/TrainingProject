package by.stn.java_exercises.modul_1.ex_23_fixed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static by.stn.java_exercises.modul_1.ex_23_fixed.Money.BankNotes.*;

/**
 * Created by EugenKrasotkin on 4/10/2018.
 */
@AllArgsConstructor
public class OperationResult {
    @Getter
    @Setter
    private Validator.Result result;
    @Getter
    private Money money;

    public OperationResult(Validator.Result result) {
        this.result = result;
    }

    public String getOperationDetails() {
        return result.isSuccess() ? "The sum " + money.getBalance() + " was cashed out with " + money.getNominal3Number() + " of " + BANKNOTE3.getNominal() + ", " + money.getNominal2Number() + " of " + BANKNOTE2.getNominal() + ", " +
                money.getNominal1Number() + " of " + BANKNOTE1.getNominal() : result.getMessage();
    }
}