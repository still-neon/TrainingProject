package by.stn.java_exercises.modul_1.ex_23_need_fix;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/27/2018.
 */
public class Money {
    @Getter
    private static final int BANKNOTE_NOMINAL_1 = 20;
    @Getter
    private static final int BANKNOTE_NOMINAL_2 = 50;
    @Getter
    private static final int BANKNOTE_NOMINAL_3 = 100;
    @Getter
    private int bankNotes1Number;
    @Getter
    private int bankNotes2Number;
    @Getter
    private int bankNotes3Number;


    public Money(int bankNotes1Number, int bankNotes2Number, int bankNotes3Number) {
        this.bankNotes1Number = bankNotes1Number;
        this.bankNotes2Number = bankNotes2Number;
        this.bankNotes3Number = bankNotes3Number;
    }

    public int getBalance() {
        return BANKNOTE_NOMINAL_1 * bankNotes1Number + BANKNOTE_NOMINAL_2 * bankNotes2Number + BANKNOTE_NOMINAL_3 * bankNotes3Number;
    }

    public void add(Money money) {
        bankNotes1Number += money.getBankNotes1Number();
        bankNotes2Number += money.getBankNotes2Number();
        bankNotes3Number += money.getBankNotes3Number();
    }

    public void remove(Money money) {
        bankNotes1Number -= money.getBankNotes1Number();
        bankNotes2Number -= money.getBankNotes2Number();
        bankNotes3Number -= money.getBankNotes3Number();
    }

    public void add(int bankNote) {//enum не секьюрно
        switch (bankNote) {
            case BANKNOTE_NOMINAL_1:
                bankNotes1Number++;
                break;
            case BANKNOTE_NOMINAL_2:
                bankNotes2Number++;
                break;
            case BANKNOTE_NOMINAL_3:
                bankNotes3Number++;
                break;
        }
    }
}