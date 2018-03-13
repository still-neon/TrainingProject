package by.stn.java_exercises.modul_1.ex_25.local_credit_cards;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public class SberbankClassic extends AbstractLocalCreditCard {
    public SberbankClassic(String cardNumber, String clientName, String bankName, int overdraftLimit) {
        super(cardNumber, clientName, bankName, overdraftLimit);
    }

    @Override
    public void withdrawMoney(int sum) {

    }

    @Override
    public void addMoney(int sum) {

    }

    @Override
    public void payByTerminal(int sum) {

    }
}
