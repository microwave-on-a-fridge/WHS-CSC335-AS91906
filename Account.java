
/**
 * Class to create accounts and deal with accounts stuff.
 *
 * @Amy Hina
 * @2025-04-11
 */

import java.util.Random;

public class Account {
    private String name;
    private String address;
    private String accountNumber;
    private String type;
    private double balance;
    
    /* this is for making new accounts */
    public Account(String name, String address, String type) { 
        this.name = name;
        this.address = address;
        this.accountNumber = accountNumberGenerator();
        this.type = type;
        this.balance = 0;
    }
    
    /* this is for loading pre-existing accounts from a csv */
    public Account(String name, String address, String accountNumber, String type, double balance) {
        this.name = name;
        this.address = address;
        this.accountNumber = accountNumber;
        this.type = type.toLowerCase();
        this.balance = balance;
    }
    
    /* to generate an account number, based on the formatting provided in the example CSV */
    public static String accountNumberGenerator() {
        Random random = new Random();
        final int ACCOUNT_NUMBER_LENGTH = 9999999;
        final int ACCOUNT_NUMBER_LENGTH_BOTTOM = 100000;
        final String ACCOUNT_NUMBER_PREFIX = "08";
        
        int accountNumberMain = random.nextInt(ACCOUNT_NUMBER_LENGTH) + ACCOUNT_NUMBER_LENGTH_BOTTOM;
        String accountNumberSecond = "010" + random.nextInt(5) + 1;
        String accountNumberLast = "0" + random.nextInt(3) + 1;
        
        String accountNumber = ACCOUNT_NUMBER_PREFIX + "-" + accountNumberSecond + "-" + accountNumberMain + "-" + accountNumberLast;
        
        return(accountNumber);
    }
    
    /* setters - i only need one for the balance lol */
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /* getters - hopefully obvious, they return the value of the thing they're getting */
    
    public String getName() {
        return(this.name);
    }
    
    public String getAddress() {
        return(this.address);
    }
    
    public String getAccountNumber() {
        return(this.accountNumber);
    }
    
    public String getType() {
        return(this.type);
    }
    
    public double getBalance() {
        return(this.balance);
    }
}
