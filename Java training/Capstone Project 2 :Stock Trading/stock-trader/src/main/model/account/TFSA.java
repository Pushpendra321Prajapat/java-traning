package src.main.model.account;

public class TFSA extends Account {

    private static final double TRADE_RATE = 0.01;

    public TFSA(double fund) {
        super(fund);
    }

    @Override
    public String buy(String stockType, int sharesToTrade, double price) {
        return super.buyTrade(stockType, sharesToTrade, price, TRADE_RATE);
    }

    @Override
    public String sell(String stockType, int sharesToTrade, double price) {
        return super.sellTrade(stockType, sharesToTrade, price, TRADE_RATE);
    }
}
