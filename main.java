
/**
 * Main class for my AS91906 project.
 *
 * @Amy Hina
 * @2025-03-31
 */

/**
 * planning:
 * 
 * this class should be for the menu navigation, which in turn means that
 * it will get used for creating objects like the account object which is what im planning
 */

public class main {
    public static void closeAccount() {
        
    }
    
    public static void main(String args[]) {
        final String[] MENU_OPTS = {"o", "c", "g", "d", "w", "q"};

        String option;
        boolean running = true;
        
        Bank bank = new Bank();

        while (running) {
            System.out.println("Kawaii-Bank Online Banking");
            System.out.println("--------------------------");
            System.out.println("O: Open an account");
            System.out.println("C: Close an account");
            System.out.println("G: Get balance of an account");
            System.out.println("D: Deposit into an account");
            System.out.println("W: Withdraw from an account");
            System.out.println("Q: Quit");

            option = Input.menu("", MENU_OPTS);

            switch (option) {
                case "o": // open account
                    Account account = new Account();
                    bank.createAccount(account);
                    //createAccount();
                    break;
                case "c": // close account
                    closeAccount();
                    break;
                case "g": // get balance
                    break;
                case "d": // deposit
                    break;
                case "w": // withdraw
                    break;
                case "q": // quit
                    System.out.println("Goodbye");
                    System.exit(0);
                    //break;
            }
        }
    }
}
