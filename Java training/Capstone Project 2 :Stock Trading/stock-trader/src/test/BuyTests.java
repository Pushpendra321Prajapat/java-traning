package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;
import src.main.model.account.Account.Stock;

public class BuyTests {

    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] { new Personal(1000), new TFSA(1000) };
    }

    @Test
    public void personalShares() {
        accounts[0].buy("AAPL", 5, 15.649286);
        assertEquals(accounts[0].getShares("AAPL"), 5);
    }

    @Test
    public void tfsaShares() {
        accounts[1].buy("AAPL", 5, 15.649286);
        assertEquals(accounts[1].getShares("AAPL"), 5);
    }

    @Test
    public void insuffientFunds() {
        accounts[0].buy("AAPL", 10000, 15.649286);
        assertEquals(accounts[0].getShares("AAPL"), 0);
    }

    @Test
    public void personalFunds() {
        accounts[0].buy("AAPL", 5, 15.649286);
        assertEquals(accounts[0].getFund(), accounts[0].round(1000 - 15.649286 * 5));
    }

    @Test
    public void TFSAFunds() {
        accounts[1].buy("AAPL", 5, 15.649286);
        assertEquals(accounts[1].getFund(), accounts[1].round(1000 - 15.649286 * 5 - 15.649286 * 5 * 0.01));
    }

}
