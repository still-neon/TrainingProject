package by.stn.java_exercises.modul_1.ex_25.international_credit_cards;

import by.stn.java_exercises.modul_1.ex_25.AbstractCreditCard;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public abstract class AbstractInternationalCreditCard extends AbstractCreditCard implements InternationalCreditCard {
    private int creditLimit;

    public AbstractInternationalCreditCard(String cardNumber, String clientName, String bankName, int creditLimit) {
        super(cardNumber, clientName, bankName);
        this.creditLimit = creditLimit;
    }
}