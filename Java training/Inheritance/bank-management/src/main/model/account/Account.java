package src.main.model.account;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Objects;

public abstract class Account {
    private String id;
    private String name;
    private double balance;

    public Account(String id, String name, double balance) {
        if (id == null || id.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("invalid parameters");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("invalid id");
        }
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(name, account.name) && balance == account.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance);
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    public abstract Account clone();

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "    " +
                "\t" + id + "" +
                "\t" + name + "" +
                "\t$" + balance + "";
    }

}
