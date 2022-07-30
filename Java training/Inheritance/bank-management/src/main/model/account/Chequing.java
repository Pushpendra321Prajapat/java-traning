package src.main.model.account;

import src.main.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable {

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source);
    }

    @Override
    public Account clone() {
        return new Chequing(this);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(round(super.getBalance() + amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if ((amount - super.getBalance()) > 200) {
            return false;
        }
        if ((super.getBalance() - amount) < 0) {
            super.setBalance(super.round(super.getBalance() - amount - 5.50));
        } else {
            super.setBalance(super.round(super.getBalance() - amount));
        }
        return true;
    }

    @Override
    public void tax(double income) {
        double tax = Math.max(0, income - 3000) * 0.15;
        super.setBalance(super.round(super.getBalance() - tax));
    }

}
