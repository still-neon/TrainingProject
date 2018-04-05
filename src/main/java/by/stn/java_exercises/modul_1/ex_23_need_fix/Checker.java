package by.stn.java_exercises.modul_1.ex_23_need_fix;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EugenKrasotkin on 4/3/2018.
 */
public class Checker {
    private static final int BASE = 100;

    public static boolean isMoneyEnough(Money total, int money) {
        return total.getBalance() > money;
    }

    public static boolean invalidValue(int money) {
        return money % 10 != 0 || money == 10 || money == 30;
    }

    public static int getBankNote(Money temp) {
        Map<Money.BankNotes, Integer> bankNotesForBase = new HashMap<Money.BankNotes, Integer>() {
            {
                put(Money.BankNotes.BANKNOTE1, temp.getNominal1Number() / 5);
                put(Money.BankNotes.BANKNOTE2, temp.getNominal2Number() / 2);
                put(Money.BankNotes.BANKNOTE3, temp.getNominal3Number());
            }
        };
        bankNotesForBase.entrySet().stream().sorted(Map.Entry.<Money.BankNotes, Integer>comparingByValue().reversed()).findFirst();
        System.out.println(bankNotesForBase);
        return bankNotesForBase.keySet().stream().findFirst().get().getNominal();
    }


    public static Map<Money.BankNotes, Integer> getBankNotesToBase(int money) {
        Map<Money.BankNotes, Integer> bankNotes = new HashMap<Money.BankNotes, Integer>() {
            {
                put(Money.BankNotes.BANKNOTE1, 0);
                put(Money.BankNotes.BANKNOTE2, 0);
                put(Money.BankNotes.BANKNOTE3, 0);
            }
        };

        switch (money % BASE) {
            case 10:
                bankNotes.put(Money.BankNotes.BANKNOTE1, 3);
                bankNotes.put(Money.BankNotes.BANKNOTE2, 1);
                break;
            case 20:
                bankNotes.put(Money.BankNotes.BANKNOTE1, 1);
                break;
            case 30:
                bankNotes.put(Money.BankNotes.BANKNOTE1, 4);
                bankNotes.put(Money.BankNotes.BANKNOTE2, 1);
                break;
            case 40:
                bankNotes.put(Money.BankNotes.BANKNOTE1, 2);
                break;
            case 50:
                bankNotes.put(Money.BankNotes.BANKNOTE2, 1);
                break;
            case 60:
                bankNotes.put(Money.BankNotes.BANKNOTE1, 3);
                break;
            case 70:
                bankNotes.put(Money.BankNotes.BANKNOTE1, 1);
                bankNotes.put(Money.BankNotes.BANKNOTE2, 1);
                break;
            case 80:
                bankNotes.put(Money.BankNotes.BANKNOTE1, 4);
                break;
            case 90:
                bankNotes.put(Money.BankNotes.BANKNOTE1, 2);
                bankNotes.put(Money.BankNotes.BANKNOTE2, 1);
                break;
        }
        return bankNotes;
    }

    public static Map<Money.BankNotes, Integer> getBankNotes(Money temp, int money) {
        int nom1 = 0;
        int nom2 = 0;
        int nom3 = 0;
        Map<Money.BankNotes, Integer> bankNotes = new HashMap<Money.BankNotes, Integer>() {
            {
                put(Money.BankNotes.BANKNOTE1, 0);
                put(Money.BankNotes.BANKNOTE2, 0);
                put(Money.BankNotes.BANKNOTE3, 0);
            }
        };

        while (money > 0) {
            switch (getBankNote(temp)) {
                case 20:
                    nom1 += 5;
                    temp.remove(Money.BankNotes.BANKNOTE1, 5);
                    break;
                case 50:
                    nom2 += 2;
                    temp.remove(Money.BankNotes.BANKNOTE2, 2);
                    break;
                case 100:
                    nom3++;
                    temp.remove(Money.BankNotes.BANKNOTE3, 1);
                    break;
            }
        }
        bankNotes.put(Money.BankNotes.BANKNOTE1, nom1);
        bankNotes.put(Money.BankNotes.BANKNOTE2, nom2);
        bankNotes.put(Money.BankNotes.BANKNOTE3, nom3);
        return bankNotes;
    }
}