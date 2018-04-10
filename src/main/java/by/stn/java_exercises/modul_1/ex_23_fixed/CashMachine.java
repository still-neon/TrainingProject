package by.stn.java_exercises.modul_1.ex_23_fixed;

public class CashMachine {
    private Money total;

    public CashMachine() {
        total = new Money();
    }

    public void addMoney(Money money) {
        total.add(money);
    }

    public boolean cashOut(int sum) {
        Validator validator = new Validator(total.clone());
        validator.tryCashOut(sum);

        validator.cashOut(sum);
        return true;
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine();
        cashMachine.addMoney(new Money(4, 2, 1));
        cashMachine.cashOut(150);
        System.out.println(validator.getOperationDetails(validator.cashOut(150)));
    }
}