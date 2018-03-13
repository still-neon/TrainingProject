package by.stn.java_exercises.modul_1.ex_25.local_credit_cards;

import by.stn.java_exercises.modul_1.ex_25.AbstractCreditCard;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public abstract class AbstractLocalCreditCard extends AbstractCreditCard implements LocalCreditCard {
    private int overdraftLimit;

    public AbstractLocalCreditCard(String cardNumber, String clientName, String bankName, int overdraftLimit) {
        super(cardNumber, clientName, bankName);
        this.overdraftLimit = overdraftLimit;
    }
}