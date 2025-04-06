
/**
 * Class to hold the accounts in.
 *
 * @Amy Hina
 * @2025-04-06
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private double totalMoney;
    
    public Bank() {
        //just let it do its thing
    }

    public void createAccount() {
        final String[] ACCOUNT_TYPES = {"everyday", "savings", "current"};
        final String[] illegal = {","};
        String name = Input.stringNoChar("Please input an account name (less than 20 characters).", 20, illegal);
        String address = Input.stringNoChar("Please input an address.", 100, illegal);
        // i read online that its better to use %n than \n for newlines in a print statement
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

        int selection = Input.integer("Please choose an account to close.", accounts.size()) - 1;

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
        }
    }

    public void withdraw() {
        int account = accountSelector();
        if (account == -1) {
            System.out.println("There are no accounts to withdraw from.");
        } else {
            double toRemove = Input.doub("Please specify an amount to withdraw.", 5000);
            double oldMoney = accounts.get(account).getBalance();

            if (toRemove-oldMoney < 0) {
                System.out.println("Not enough money in account to withdraw that amount.");
            } else {
                accounts.get(account).setBalance(oldMoney - toRemove);
            }
        }
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
                double balance = Double.parseDouble(separated[4]);
                // there has to be a better way to do this
                this.accounts.add(new Account(separated[0], separated[1], separated[2], separated[3], balance));
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
                writer.write(account.getAccountNumber() + ",");
                writer.write(account.getAddress() + ",");
                writer.write(account.getType() + ",");
                writer.write(account.getBalance() + ",");
            }
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    // mainly for debugging
    public void printAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getName());
            System.out.println(account.getAccountNumber());
            System.out.println(account.getAddress());
            System.out.println(account.getType());
            System.out.println(account.getBalance());
            System.out.println();
        }
    }
}