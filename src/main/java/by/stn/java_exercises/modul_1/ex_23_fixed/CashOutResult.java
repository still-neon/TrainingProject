package by.stn.java_exercises.modul_1.ex_23_fixed;

import lombok.Getter;
import lombok.Setter;

import static by.stn.java_exercises.modul_1.ex_23_fixed.Money.BankNotes.*;

/**
 * Created by EugenKrasotkin on 4/10/2018.
 */
public class CashOutResult {
    @Getter
    @Setter
    private Validator.Result result;
    @Getter
    @Setter
    private int nominal1Number;
    @Getter
    @Setter
    private int nominal2Number;
    @Getter
    @Setter
    private int nominal3Number;

    public CashOutResult(Validator.Result result) {
        this.result = result;
    }

    public String getOperationDetails() {
        return result.isSuccess() ? "The sum was cashed out with " + nominal3Number + " of " + BANKNOTE3.getNominal() + ", " + nominal2Number + " of " + BANKNOTE2.getNominal() + ", " +
                nominal1Number + " of " + BANKNOTE1.getNominal() : result.getMessage();
    }
}