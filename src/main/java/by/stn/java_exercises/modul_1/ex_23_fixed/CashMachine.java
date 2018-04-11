package by.stn.java_exercises.modul_1.ex_23_fixed;

public class CashMachine {
    private Money total;

    public CashMachine() {
        total = new Money();
    }

    public void addMoney(Money money) {
        total.add(money);
    }

    public Result cashOut(int sum) {
        Result result = new Validator(total.clone()).tryCashOut(sum);

        if (result.getValidationResult().isSuccess()) {
            total.remove(new Money());
        }
        return result;
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine();
        cashMachine.addMoney(new Money(40, 2, 1));
        System.out.println(cashMachine.cashOut(150).getOperationDetails());
    }
}