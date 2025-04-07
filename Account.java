
/**
 * Class to create accounts and deal with accounts stuff.
 *
 * @Amy Hina
 * @2025-04-07
 */

import java.util.Random;

public class Account {
    private String name;
    private String accountNumber;
    private String address;
    private String type;
    private double balance;
    
    // this is for making new accounts
    public Account(String name, String address, String type) { 
        this.name = name;
        this.accountNumber = accountNumberGenerator();
        this.address = address;
        this.type = type;
        this.balance = 0;
    }
    
    // this is for loading pre-existing accounts from a csv
    public Account(String name, String accountNumber, String address, String type, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.address = address;
        this.type = type;
        this.balance = balance;
    }
    
    public static String accountNumberGenerator() {
        Random random = new Random();
        final int ACCOUNT_NUMBER_LENGTH = 99999999;
        final int ACCOUNT_NUMBER_LENGTH_BOTTOM = 1000000;
        final String ACCOUNT_NUMBER_PREFIX = "38";
        
        int accountNumberMain = random.nextInt(ACCOUNT_NUMBER_LENGTH) + ACCOUNT_NUMBER_LENGTH_BOTTOM;
        
        String accountNumber = ACCOUNT_NUMBER_PREFIX + "-" + accountNumberMain;
        
        return(accountNumber);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public String getName() {
        return(this.name);
    }
    
    public String getAccountNumber() {
        return(this.accountNumber);
    }
    
    public String getAddress() {
        return(this.address);
    }
    
    public String getType() {
        return(this.type);
    }
    
    public double getBalance() {
        return(this.balance);
    }
}
