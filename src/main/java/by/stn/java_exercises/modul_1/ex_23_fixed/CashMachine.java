package by.stn.java_exercises.modul_1.ex_23_fixed;

public class CashMachine {
    private Money total;

    public CashMachine() {
        total = new Money();
    }

    public void addMoney(Money money) {
        total.add(money);
    }

    public OperationResult cashOut(int sum) {
        OperationResult operationResult = new Validator(total.clone()).tryCashOut(sum);

        if (operationResult.getResult().isSuccess()) {//is sucess у опретаион резалт
            total.remove(operationResult.getMoney());
        }
        return operationResult;
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine();
        cashMachine.addMoney(new Money(4, 2, 1));
        System.out.println(cashMachine.cashOut(150).getOperationDetails());
    }
}