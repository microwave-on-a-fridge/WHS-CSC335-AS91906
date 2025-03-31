
/**
 * Class to create accounts and deal with accounts stuff.
 *
 * @Amy Hina
 * @2025-03-31
 */

import java.util.Random;

public class Account {
    private String name;
    private int accountNumber;
    private String address;
    private String type;
    private int balance;
    
    public Account() {
        // idk this makes it not error out who knows
    }
    
    public Account(String name, String address, String type, int balance) {
        Random random = new Random();
        final int accountNumberLength = 8;
        
        this.name = name;
        this.address = address;
        this.type = type;
        this.balance = balance;
        
        this.accountNumber = random.nextInt(accountNumberLength);
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
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
