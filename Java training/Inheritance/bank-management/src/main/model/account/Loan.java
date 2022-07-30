package src.main.model.account;

public class Loan extends Account {

    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan(Loan source) {
        super(source);
    }

    @Override
    public Account clone() {
        return new Loan(this);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.round(super.getBalance() - amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if ((super.getBalance() + amount) > 10000) {
            return false;
        } else {
            super.setBalance(super.round(super.getBalance() + amount + amount * 0.02));
            return true;
        }

    }

}
