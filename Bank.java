
/**
 * Class to hold the accounts in.
 *
 * @Amy Hina
 * @2025-03-31
 */

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Bank() {
        //this.accounts.add(new Account());
    }
    
    public void createAccount(Account account) {
        final String[] accountTypes = {"everyday", "savings", "current"};
        
        this.accounts.add(account);
        
        String name = Input.string("Please input an account name! (less than 20 characters)", 20);
        //int accountNumber = Input.integer("Please input an account name! (less than 20 characters)", 20);
        String address = Input.string("Please input an address!", 100);
        String type = Input.menu("Please choose an account type!", accountTypes);
        //int balance = Input.integer("Please input an account name! (less than 20 characters)", 20);
        
        
        account.setName(name);
        account.setAddress(address);
        account.setType(type);
    }
}
