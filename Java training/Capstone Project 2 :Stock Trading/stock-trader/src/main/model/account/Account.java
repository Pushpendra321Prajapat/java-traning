package src.main.model.account;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Objects;

import src.main.utils.Color;

public abstract class Account {
    private static String portFolio = "";

    public enum Stock {
        AAPL, TSLA, GOOG, FB
    }

    private double fund;
    private HashMap<Stock, Integer> portfolio;

    public Account(double fund) {
        this.fund = fund;
        this.portfolio = new HashMap<Stock, Integer>();
        portfolio.put(Stock.AAPL, 0);
        portfolio.put(Stock.TSLA, 0);
        portfolio.put(Stock.GOOG, 0);
        portfolio.put(Stock.FB, 0);
    }

    public double getFund() {
        return this.fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public double round(double val) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(val));
    }

    protected void setShares(String stockType, int sharesToTrade) {
        Stock stock = Stock.valueOf(stockType);
        this.portfolio.put(stock, this.portfolio.get(stock) + sharesToTrade);
    }

    public int getShares(String stockType) {
        return this.portfolio.get(Stock.valueOf(stockType));
    }

    @Override
    public String toString() {
        portFolio = "";
        portFolio += "Stock" + "\t\t" + "share" + "\n\n";
        portfolio.entrySet().stream()
                .forEach(entry -> {
                    portFolio += (Color.BLUE + entry.getKey());
                    portFolio += "\t\t";
                    portFolio += (Color.GREEN + entry.getValue());
                    portFolio += "\n";
                });
        portFolio += Color.RESET;
        portFolio += "\nFunds Left\t\t" + Color.GREEN + "$" + this.getFund() + Color.RESET;
        return portFolio + "\n";

    }

    public abstract String buy(String stockType, int sharesToTrade, double price);

    public abstract String sell(String stockType, int sharesToTrade, double price);

    protected String buyTrade(String stockType, int sharesToTrade, double price, double buyRate) {
        double totalPrice = sharesToTrade * price;
        if (totalPrice > this.getFund()) {
            return "unsuccessful";
        }
        double netPrice = totalPrice * (1 + buyRate);
        this.setFund(round(this.getFund() - netPrice));
        this.setShares(stockType, sharesToTrade);

        return "successful";
    }

    protected String sellTrade(String stockType, int sharesToTrade, double price, double sellRate) {
        if (this.getShares(stockType) < sharesToTrade) {
            return "unsuccessful";
        }
        double totalPrice = sharesToTrade * price;
        double netPrice = totalPrice * (1 - sellRate);
        this.setFund(round(this.getFund() + netPrice));

        this.setShares(stockType, -sharesToTrade);
        return "successful";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return fund == account.fund && Objects.equals(portfolio, account.portfolio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fund, portfolio);
    }

}
