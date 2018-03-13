package by.stn.java_exercises.modul_1.ex_25.international_credit_cards;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public class VisaGold extends AbstractInternationalCreditCard {
    public VisaGold(String cardNumber, String clientName, String bankName, int creditLimit) {
        super(cardNumber, clientName, bankName, creditLimit);
    }

    @Override
    public void withdrawMoney(int sum) {

    }

    @Override
    public void addMoney(int sum) {

    }

    @Override
    public void payByInternet(int sum) {

    }
}
