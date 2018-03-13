package by.stn.java_exercises.modul_1.ex_25;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public abstract class AbstractCreditCard implements CreditCard {
    private String cardNumber;
    private String clientName;
    private String bankName;

    public AbstractCreditCard(String cardNumber, String clientName, String bankName) {
        this.cardNumber = cardNumber;
        this.clientName = clientName;
        this.bankName = bankName;
    }
}
