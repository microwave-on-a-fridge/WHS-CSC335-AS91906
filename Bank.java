
/**
 * Class to hold the accounts in and handle most of the logic.
 *
 * @Amy Hina
 * @2025-04-11
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private final double TRANSACTION_LIMIT = 5000;
    private double totalMoney = 0;
    private double totalDifference = 0;

    /* create an account letting the user input name, address, and type (account number is random and balance is 0) */
    public void createAccount() {
        final String[] ACCOUNT_TYPES = {"everyday", "savings", "current"};
        final String[] illegal = {","};
        String name = Input.stringNoChar("Please input an account name (less than 20 characters).", 20, illegal);
        String address = Input.stringNoChar("Please input an address.", 100, illegal);
        String type = Input.menu("Please choose an account type from the following:\nEveryday\nSavings\nCurrent", ACCOUNT_TYPES);
        this.accounts.add(new Account(name, address, type));
        Input.clear();
        System.out.println("Created account \"" + name + "\".");
    }

    /* method for choosing account from an array of accounts */
    public int accountSelector() {
        if (accounts.size() <= 0) {
            return(-1);
        }
        System.out.println("Accounts:");
        for (int i=0; i<accounts.size(); i++) {
            System.out.println(i+1 + ". " + accounts.get(i).getName());
        }

        int selection = Input.integer("Please choose an account.", accounts.size()) - 1;

        return(selection);
    }

    /**
     * close account method with confirmation feature because accidentally closing something is bad
     * thank you game design for teaching me about nielsen heuristics
     * gotta take those heuristics into account
     */
    public void closeAccount() {
        int toRemove = accountSelector();
        if (toRemove == -1) {
            System.out.println("There are no accounts to close.");
        } else {
            boolean confirmation = Input.yesNo("Are you sure you want to close " + accounts.get(toRemove).getName() + "? (y/N)", false);
            if (confirmation) {
                Input.clear();
                System.out.println("Closed account \"" + accounts.get(toRemove).getName() + "\".");
                accounts.remove(toRemove);
            } else {
                Input.clear();
                System.out.println("Account not closed.");
            }
        }
    }

    /* print only the balance of a chosen account */
    public void checkBalance() {
        int account = accountSelector();
        if (account == -1) {
            System.out.println("There are no accounts to view the balance of.");
        } else {
            System.out.println("$" + String.format("%.2f", accounts.get(account).getBalance()));
        }
    }

    /* allow user to input a number and then add that to the balance of the chosen account */
    public void deposit() {
        int account = accountSelector();
        if (account == -1) {
            System.out.println("There are no accounts to deposit to.");
        } else {
            double toAdd = Input.doub("Please specify an amount to deposit.", TRANSACTION_LIMIT);
            double oldMoney = accounts.get(account).getBalance();

            accounts.get(account).setBalance(oldMoney + toAdd);
            totalDifference += toAdd;

            Input.clear();
            System.out.println("Deposited $" + String.format("%.2f", toAdd) + " to " + accounts.get(account).getName() + ".");
        }
    }

    /**
     * this is ugly but it works
     * if account type is current (overdraft account), allow withdraw up to $1k
     * otherwise only allow withdraw if account has money
     */
    public void withdraw() {
        final double OVERDRAFT = 1000;
        int account = accountSelector();
        if (account == -1) {
            System.out.println("There are no accounts to withdraw from.");
        } else {
            double toRemove = Input.doub("Please specify an amount to withdraw.", TRANSACTION_LIMIT);
            double oldMoney = accounts.get(account).getBalance();

            if (accounts.get(account).getType().equals("current") && toRemove-oldMoney > OVERDRAFT) { // if account supports overdraft but the amount trying to withdraw goes less than -1k, dont
                System.out.println("Overdraft cannot go over $" + OVERDRAFT + ".");
            } else if (accounts.get(account).getType().equals("current") && toRemove-oldMoney <= OVERDRAFT) {
                accounts.get(account).setBalance(oldMoney - toRemove);
                totalDifference -= toRemove;
                Input.clear();
                System.out.println("Withdrew $" + String.format("%.2f", toRemove) + " from " + accounts.get(account).getName() + " (overdraft).");
            } else if (toRemove-oldMoney > 0) {
                System.out.println("Not enough money in account to withdraw that amount.");
            } else {
                accounts.get(account).setBalance(oldMoney - toRemove);
                totalDifference -= toRemove;
                Input.clear();
                System.out.println("Withdrew $" + String.format("%.2f", toRemove) + " from " + accounts.get(account).getName() + ".");
            }
        }
    }

    /* print all the stuff in an account for each account */
    public void printAccounts() {
        if (accounts.size() <= 0) {
            System.out.println("There are no accounts.");
        } else {
            for (int i=0; i<accounts.size(); i++) {
                Account account = accounts.get(i);
                System.out.println(i+1 + ".");
                //System.out.println("Java ID: " + account); leaving this commented rather than removing because might need later
                System.out.println("Name: " + account.getName());
                System.out.println("Address: " + account.getAddress());
                System.out.println("Account number: " + account.getAccountNumber());
                System.out.println("Account type: " + account.getType());
                System.out.println("Account balance: $" + String.format("%.2f", account.getBalance()));
                System.out.println();
            }
        }
    }

    /* getters for the total money in the bank and outcome of all the transactions */
    
    public double getTotalMoney() {
        for (Account account : accounts) {
            totalMoney = totalMoney + account.getBalance();
        }
        return(totalMoney);
    }

    public double getTotalDifference() {
        return(totalDifference);
    }

    /* FILE RELATED THINGS */

    public void readCSV(String fileName) {
        File csvFile = new File(fileName);
        try {
            Scanner reader = new Scanner(csvFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] separated = line.split(",");
                /* add the values from the array of comma separated items to a new account */
                this.accounts.add(new Account(separated[0], separated[1], separated[2], separated[3], Double.parseDouble(separated[4])));
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
    }

    /* write the account information to a CSV */
    public void writeCSV(String fileName) {
        File csvFile = new File(fileName);
        try {
            FileWriter writer = new FileWriter(csvFile);
            for (Account account : accounts) {
                writer.write(account.getName() + ",");
                writer.write(account.getAddress() + ",");
                writer.write(account.getAccountNumber() + ",");
                writer.write(account.getType() + ",");
                writer.write(account.getBalance() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}
