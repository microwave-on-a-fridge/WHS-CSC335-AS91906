
/**
 * Class to hold the accounts in.
 *
 * @Amy Hina
 * @2025-04-01
 */

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Bank() {
        //just let it do its thing
    }
    
    public void createAccount() {
        final String[] ACCOUNT_TYPES = {"everyday", "savings", "current"};
        
        String name = Input.string("Please input an account name (less than 20 characters).", 20);
        String address = Input.string("Please input an address.", 100);
        String type = Input.menu("Please choose an account type.", ACCOUNT_TYPES);
        
        this.accounts.add(new Account(name, address, type));        
    }
    
    public void closeAccount() {
        System.out.println("Accounts:");
        for (int i=0; i<accounts.size(); i++) {
            System.out.println(i+1 + ". " + accounts.get(i).getName());
        }
        
        int toRemove = Input.integer("Please choose an account to close.", accounts.size()) - 1;

        boolean confirmation = Input.yesNo("Are you sure you want to remove " + toRemove + 1 + "? (y/N)", false);
        if (confirmation) {
            accounts.remove(toRemove);
        } else {
            System.out.println("Account not deleted.");
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