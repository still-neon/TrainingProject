package by.stn.java_exercises.modul_1.ex_23_fixed;

public class CashMachine {
    private Money total;

    public CashMachine() {
        total = new Money();
    }

    public void addMoney(Money money) {
        total.add(money);
    }

    public CashOutResult cashOut(int sum) {
        CashOutResult cashOutResult = new Validator(total.clone()).tryCashOut(sum);

        if (cashOutResult.getResult().isSuccess()) {
            total.remove(new Money(cashOutResult.getNominal1Number(),cashOutResult.getNominal2Number(),cashOutResult.getNominal3Number()));
        }
        return cashOutResult;
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine();
        cashMachine.addMoney(new Money(4, 2, 1));
        System.out.println(cashMachine.cashOut(1550).getOperationDetails());
    }
}