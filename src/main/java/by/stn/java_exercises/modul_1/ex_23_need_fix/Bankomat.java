package by.stn.java_exercises.modul_1.ex_23_need_fix;

public class Bankomat {//деньги отдельным классом представление
    private static final int BANKNOTE_NOMINAL_1 = 20;
    private static final int BANKNOTE_NOMINAL_2 = 50;
    private static final int BANKNOTE_NOMINAL_3 = 100;
    private int numberOfBanknotesNominal1;
    private int numberOfBanknotesNominal2;
    private int numberOfBanknotesNominal3;

    private int cashSum = 0;
    private int cashedNominal1Number = 0;//не поля класса
    private int cashedNominal2Number = 0;
    private int cashedNominal3Number = 0;

    public Bankomat(int numberOfBanknotesNominal1, int numberOfBanknotesNominal2, int numberOfBanknotesNominal3) {
        this.numberOfBanknotesNominal1 = numberOfBanknotesNominal1;
        this.numberOfBanknotesNominal2 = numberOfBanknotesNominal2;
        this.numberOfBanknotesNominal3 = numberOfBanknotesNominal3;
    }

    public void addMoney(int numberOfBanknotesNominal1, int numberOfBanknotesNominal2, int numberOfBanknotesNominal3) {
        this.numberOfBanknotesNominal1 += numberOfBanknotesNominal1;
        this.numberOfBanknotesNominal2 += numberOfBanknotesNominal2;
        this.numberOfBanknotesNominal3 += numberOfBanknotesNominal3;
    }

    private int getMoneyAmount() {
        return BANKNOTE_NOMINAL_1 * numberOfBanknotesNominal1 + BANKNOTE_NOMINAL_2 * numberOfBanknotesNominal2 + BANKNOTE_NOMINAL_3 * numberOfBanknotesNominal3;
    }

    private boolean controlOperation(int sumOfMoney) {
        boolean operationStatus = false;
        if (sumOfMoney - cashSum >= BANKNOTE_NOMINAL_1 && numberOfBanknotesNominal1 > 0) {
            cashSum += BANKNOTE_NOMINAL_1;
            cashedNominal1Number++;
            numberOfBanknotesNominal1--;
            operationStatus = true;
        }
        if (sumOfMoney - cashSum >= BANKNOTE_NOMINAL_2 && numberOfBanknotesNominal2 > 0) {
            cashSum += BANKNOTE_NOMINAL_2;
            cashedNominal2Number++;
            numberOfBanknotesNominal2--;
            operationStatus = true;
        }
        if (sumOfMoney - cashSum >= BANKNOTE_NOMINAL_3 && numberOfBanknotesNominal3 > 0) {
            cashSum += BANKNOTE_NOMINAL_3;
            cashedNominal3Number++;//CallBack юзать, возможно отдельный класс
            numberOfBanknotesNominal3--;
            operationStatus = true;
        }
        return operationStatus;
    }

    public boolean getMoney(int sumOfMoney) {
        if (sumOfMoney > getMoneyAmount())
            return false;

        while (sumOfMoney != cashSum) {
            if (!controlOperation(sumOfMoney)) {
                System.out.println("Try another sum");
                return false;
            }
        }
        System.out.println("The money sum " + cashSum + " was cashed with " + cashedNominal3Number + " of " + BANKNOTE_NOMINAL_3 + ", " + cashedNominal2Number + " of " + BANKNOTE_NOMINAL_2 + ", " + cashedNominal1Number + " of " + BANKNOTE_NOMINAL_1);
        return true;
    }

    public static void main(String[] args) {
        Bankomat money = new Bankomat(6, 5, 5);

        money.getMoney(310);
    }
}