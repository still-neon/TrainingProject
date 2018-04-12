package by.stn.java_exercises.modul_1.ex_23;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/27/2018.
 */
public class Money {
    @Getter
    private static final int INVALID_VALUE1 = 10;
    @Getter
    private static final int INVALID_VALUE2 = 30;
    @Getter
    private static final int NOMINAL1 = 20;
    @Getter
    private static final int NOMINAL2 = 50;
    @Getter
    private static final int NOMINAL3 = 100;
    @Getter
    private static final int BASE = 10;
    @Getter
    private int nominal1Number;
    @Getter
    private int nominal2Number;
    @Getter
    private int nominal3Number;


    public Money() {
    }

    public Money(int nominal1Number, int nominal2Number, int nominal3Number) {
        this.nominal1Number = nominal1Number;
        this.nominal2Number = nominal2Number;
        this.nominal3Number = nominal3Number;
    }

    public int getBalance() {
        return NOMINAL1 * nominal1Number + NOMINAL2 * nominal2Number + NOMINAL3 * nominal3Number;
    }

    public void add(Money money) {
        nominal1Number += money.getNominal1Number();
        nominal2Number += money.getNominal2Number();
        nominal3Number += money.getNominal3Number();
    }

    public void add(BankNotes bankNote, int number) {
        switch (bankNote) {
            case BANKNOTE1:
                nominal1Number += number;
                break;
            case BANKNOTE2:
                nominal2Number += number;
                break;
            case BANKNOTE3:
                nominal3Number += number;
                break;
        }
    }

    public void remove(Money money) {
        nominal1Number -= money.getNominal1Number();
        nominal2Number -= money.getNominal2Number();
        nominal3Number -= money.getNominal3Number();
    }

    public void remove(BankNotes bankNote, int number) {
        switch (bankNote) {
            case BANKNOTE1:
                nominal1Number -= number;
                break;
            case BANKNOTE2:
                nominal2Number -= number;
                break;
            case BANKNOTE3:
                nominal3Number -= number;
                break;
        }
    }

    public Money clone() {
        Money money = new Money();
        money.add(this);
        return money;
    }

    public enum BankNotes {
        BANKNOTE1(NOMINAL1), BANKNOTE2(NOMINAL2), BANKNOTE3(NOMINAL3);
        @Getter
        private int nominal;

        BankNotes(int nominal) {
            this.nominal = nominal;
        }
    }
}