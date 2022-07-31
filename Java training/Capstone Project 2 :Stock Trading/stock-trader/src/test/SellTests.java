package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

public class SellTests {

    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] { new Personal(1000), new TFSA(1000) };
        for (int i = 0; i < accounts.length; i++) {
            accounts[i].buy("AAPL", 5, 15.649286);
        }
    }

    @Test
    public void personalShares() {
        accounts[0].sell("AAPL", 3, 15.649286);
        assertEquals(accounts[0].getShares("AAPL"), 2);
    }

    @Test
    public void tfsaShares() {
        accounts[1].sell("AAPL", 2, 15.649286);
        assertEquals(accounts[1].getShares("AAPL"), 3);
    }

    @Test
    public void insuffientShares() {
        accounts[0].sell("AAPL", 10, 15.649286);
        assertEquals(accounts[0].getShares("AAPL"), 5);
    }

    @Test
    public void personalFunds() {
        double currentBalance = accounts[0].getFund();

        accounts[0].sell("AAPL", 5, 15.649286);
        assertEquals(accounts[0].getFund(),
                accounts[0].round(currentBalance + (15.649286 * 5) - (15.649286 * 5 * 0.05)));
    }

    @Test
    public void TFSAFunds() {
        double currentBalance = accounts[1].getFund();

        accounts[1].sell("AAPL", 5, 15.649286);
        assertEquals(accounts[1].getFund(),
                accounts[1].round(currentBalance + (15.649286 * 5) - (15.649286 * 5 * 0.01)));
    }

}
