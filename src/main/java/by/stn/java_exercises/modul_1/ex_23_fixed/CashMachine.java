package by.stn.java_exercises.modul_1.ex_23_fixed;

public class CashMachine {
    private static Money total;

    public CashMachine() {
        total = new Money();
    }

    public Checker.Result cashOut(int sum) {
        Checker.Result result = Checker.isCashReady(total, sum);

        if(result.isSuccess()) {
            Operator.getCash(total);
        }
        return result;
    }

    public static void putMoney(Money money) {
        total.add(money);
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine();
        putMoney(new Money(70, 30, 22));
        System.out.println(cashMachine.cashOut(2970).getMessage());
    }
}