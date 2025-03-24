
/**
 * Class to create accounts and deal with accounts stuff.
 *
 * @Amy Hina
 * @2025-03-25
 */



public class Account {
    private String name;
    private int accountNumber;
    private String address;
    private String type;
    private int balance;
    
    public Account(String name, int accountNumber, String address, String type, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.address = address;
        this.type = type;
        this.balance = balance;
    }
}
