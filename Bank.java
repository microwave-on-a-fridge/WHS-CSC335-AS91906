
/**
 * Class to hold the accounts in.
 *
 * @Amy Hina
 * @2025-04-07
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private double totalMoney = 0;
    private double totalDifference = 0;

    public void createAccount() {
        final String[] ACCOUNT_TYPES = {"everyday", "savings", "current"};
        final String[] illegal = {","};
        String name = Input.stringNoChar("Please input an account name (less than 20 characters).", 20, illegal);
        String address = Input.stringNoChar("Please input an address.", 100, illegal);
        String type = Input.menu("Please choose an account type from the following:\nEveryday\nSavings\nCurrent", ACCOUNT_TYPES);
        this.accounts.add(new Account(name, address, type));        
    }

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

    public void closeAccount() {
        int toRemove = accountSelector();
        if (toRemove == -1) {
            System.out.println("There are no accounts to close.");
        } else {
            boolean confirmation = Input.yesNo("Are you sure you want to close " + accounts.get(toRemove).getName() + "? (y/N)", false);
            if (confirmation) {
                System.out.println("Closed " + accounts.get(toRemove).getName() + ".");
                accounts.remove(toRemove);
            } else {
                System.out.println("Account not closed.");
            }
        }
    }

    public void checkBalance() {
        int account = accountSelector();
        if (account == -1) {
            System.out.println("There are no accounts to view the balance of.");
        } else {
            System.out.println(accounts.get(account).getBalance());
        }
    }

    public void deposit() {
        int account = accountSelector();
        if (account == -1) {
            System.out.println("There are no accounts to deposit to.");
        } else {
            double toAdd = Input.doub("Please specify an amount to deposit.", 5000);
            double oldMoney = accounts.get(account).getBalance();

            accounts.get(account).setBalance(oldMoney + toAdd);
            totalDifference += toAdd;
        }
    }

    public void withdraw() {
        final double OVERDRAFT = 1000;
        int account = accountSelector();
        if (account == -1) {
            System.out.println("There are no accounts to withdraw from.");
        } else {
            double toRemove = Input.doub("Please specify an amount to withdraw.", 5000);
            double oldMoney = accounts.get(account).getBalance();
            // do testing on this
            if (accounts.get(account).getType().equals("current") && toRemove-oldMoney >= OVERDRAFT) {
                System.out.println("Overdraft cannot go over $" + OVERDRAFT + ".");
            } else if (accounts.get(account).getType().equals("current") && toRemove-oldMoney < OVERDRAFT) {
                accounts.get(account).setBalance(oldMoney - toRemove);
                totalDifference -= toRemove;
            } else if (toRemove-oldMoney > 0) {
                System.out.println("Not enough money in account to withdraw that amount.");
            } else {
                accounts.get(account).setBalance(oldMoney - toRemove);
                totalDifference -= toRemove;
            }
        }
    }
    
    public void printAccounts() {
        for (int i=0; i<accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.println(i+1 + ".");
            //System.out.println("Java ID: " + account);
            System.out.println("Name: " + account.getName());
            System.out.println("Address: " + account.getAddress());
            System.out.println("Account number: " + account.getAccountNumber());
            System.out.println("Account type: " + account.getType());
            System.out.println("Account balance: $" + account.getBalance());
            System.out.println();
        }
    }
    
    public double getTotalMoney() {
        for (Account account : accounts) {
            totalMoney = totalMoney + account.getBalance();
        }
        return(totalMoney);
    }
    
    public double getTotalDifference() {
        return(totalDifference);
    }
    
    /*
     * FILE RELATED THINGS
     */
    
    // untested, please do testing on these
    
    public void readCSV(String fileName) {
        File csvFile = new File(fileName);
        try {
            Scanner reader = new Scanner(csvFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] separated = line.split(",");
                // there has to be a better way to do this
                this.accounts.add(new Account(separated[0], separated[1], separated[2], separated[3], Double.parseDouble(separated[4])));
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
    }
    
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
