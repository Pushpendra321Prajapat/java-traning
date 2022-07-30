package src.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import src.main.model.Bank;
import src.main.model.Transaction;
import src.main.model.account.Account;
import src.main.model.account.Chequing;
import src.main.model.account.Loan;
import src.main.model.account.Savings;

public class Main {

    static Bank bank = new Bank();

    static String ACCOUNTS_FILE = "src/main/data/accounts.txt";
    static String TRANSACTIONS_FILE = "src/main/data/transactions.txt";

    public static void main(String[] args) {

        // Chequing chequing = new Chequing("f84c43f4-a634-4c57-a644-7602f8840870",
        // "Michael Scott", 1524.51);
        // Savings savings = new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul
        // Goodman", 2241.60);
        // Loan loan = new Loan("4991bf71-ae8f-4df9-81c1-9c79cff280a5", "Phoebe Buffay",
        // 2537.31);

        // System.out.println(chequing);
        // System.out.println(savings);
        // System.out.println(loan);

        // Chequing chequing = new Chequing("f84c43f4-a634-4c57-a644-7602f8840870",
        // "Michael Scott", 1524.51);
        // Account chequingCopy = chequing.clone();

        // Savings savings = new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul
        // Goodman", 2241.60);
        // Account savingsCopy = savings.clone();

        // Bank bank = new Bank();

        // Account[] accounts = new Account[] {
        // new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott",
        // 1524.51),
        // new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul Goodman", 2241.60)
        // };

        // for (Account account : accounts) {
        // bank.addAccount(account);
        // }

        // Transaction[] transactions = new Transaction[] {
        // new Transaction(Transaction.Type.WITHDRAW, 1546905600,
        // "f84c43f4-a634-4c57-a644-7602f8840870", 624.99),
        // new Transaction(Transaction.Type.DEPOSIT, 1578700800,
        // "f84c43f4-a634-4c57-a644-7602f8840870", 441.93),
        // new Transaction(Transaction.Type.WITHDRAW, 1547078400,
        // "f84c43f4-a634-4c57-a644-7602f8840870", 546.72),
        // new Transaction(Transaction.Type.WITHDRAW, 1546732800,
        // "f84c43f4-a634-4c57-a644-7602f8840870", 546.72),
        // new Transaction(Transaction.Type.DEPOSIT, 1578355200,
        // "f84c43f4-a634-4c57-a644-7602f8840870", 635.95),
        // new Transaction(Transaction.Type.WITHDRAW, 1547078400,
        // "ce07d7b3-9038-43db-83ae-77fd9c0450c9", 875.64),
        // new Transaction(Transaction.Type.WITHDRAW, 1578614400,
        // "ce07d7b3-9038-43db-83ae-77fd9c0450c9", 912.45),
        // new Transaction(Transaction.Type.WITHDRAW, 1577836800,
        // "ce07d7b3-9038-43db-83ae-77fd9c0450c9", 695.09),
        // new Transaction(Transaction.Type.WITHDRAW, 1609459200,
        // "ce07d7b3-9038-43db-83ae-77fd9c0450c9", 917.21),
        // new Transaction(Transaction.Type.WITHDRAW, 1578096000,
        // "ce07d7b3-9038-43db-83ae-77fd9c0450c9", 127.94),
        // new Transaction(Transaction.Type.WITHDRAW, 1546819200,
        // "ce07d7b3-9038-43db-83ae-77fd9c0450c9", 612.52)
        // };

        // for (Transaction transaction : transactions) {
        // // bank.addTransaction(transaction);
        // }

        // Transaction[] filteredTransactions =
        // bank.getTransactions("f84c43f4-a634-4c57-a644-7602f8840870");
        // Account account = bank.getAccount("ce07d7b3-9038-43db-83ae-77fd9c0450c9");

        // createObject(new String[] { "Chequing",
        // "f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", "1524.51" });

        // try {
        // System.out.println(returnTransactions());
        // returnAccounts();
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }
        // System.out.println(c);

        try {
            ArrayList<Account> accounts = returnAccounts();
            loadAccounts(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransactions(transactions);
            bank.deductTaxes();
            for (Account account : accounts) {
                System.out.println("\n\t\t\t\t\t ACCOUNT\n\n\t" + account + "\n\n");
                transactionHistory(account.getId());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Function name: wait
     * 
     * @param milliseconds
     * 
     *                     Inside the function:
     *                     1. Makes the code sleep for X milliseconds.
     */

    public static void wait(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Account createObject(String[] values) {
        try {
            return (Account) Class.forName("src.main.model.account." + values[0])
                    .getConstructor(String.class, String.class, double.class)
                    .newInstance(values[1], values[2], Double.parseDouble(values[3]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList<Account> returnAccounts() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
        Scanner sc = new Scanner(fis);

        ArrayList<Account> accounts = new ArrayList<Account>();

        while (sc.hasNextLine()) {
            accounts.add(createObject(sc.nextLine().split(",")));
        }
        sc.close();
        return accounts;
    }

    public static void loadAccounts(ArrayList<Account> accounts) {
        for (Account account : accounts) {
            bank.addAccount(account);
        }
    }

    public static ArrayList<Transaction> returnTransactions() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(TRANSACTIONS_FILE);
        Scanner scan = new Scanner(fis);

        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        while (scan.hasNextLine()) {
            String[] values = scan.nextLine().split(",");
            transactions.add(new Transaction(Transaction.Type.valueOf(values[1]), Long.parseLong(values[0]), values[2],
                    Double.parseDouble(values[3])));
        }

        scan.close();
        Collections.sort(transactions);
        return transactions;
    }

    public static void runTransactions(ArrayList<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            bank.executeTransaction(transaction);
        }
    }

    public static void transactionHistory(String id) {
        System.out.println("\t\t\t\t   TRANSACTION HISTORY\n\t");
        for (Transaction transaction : bank.getTransactions(id)) {
            wait(300);
            System.out.println("\t" + transaction + "\n");
        }
        System.out.println("\n\t\t\t\t\tAFTER TAX\n");
        System.out.println("\t" + bank.getAccount(id) + "\n\n\n\n");
    }

}
