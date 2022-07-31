package src.main.model.account;

public class Personal extends Account {

    private static final double BUY_RATE = 0.0;
    private static final double SELL_RATE = 0.05;

    public Personal(double fund) {
        super(fund);
    }

    @Override
    public String buy(String stockType, int sharesToTrade, double price) {
        return super.buyTrade(stockType, sharesToTrade, price, BUY_RATE);
    }

    @Override
    public String sell(String stockType, int sharesToTrade, double price) {
        return super.sellTrade(stockType, sharesToTrade, price, SELL_RATE);
    }
}
