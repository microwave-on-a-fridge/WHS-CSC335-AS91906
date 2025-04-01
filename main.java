
/**
 * Main class for my AS91906 project.
 *
 * @Amy Hina
 * @2025-04-02
 */

// todo: fix y/n for close account, add error message thingy to my input methods, basically
// just work on my input class cuz that shit is kinda cooked right now

public class main {
    public static void main(String args[]) {
        final String[] MENU_OPTS = {"o", "c", "g", "d", "w", "i", "q"};
        
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
            System.out.println("I: Display account info");
            System.out.println("Q: Quit");

            option = Input.menu("", MENU_OPTS);

            switch (option) {
                case "o": // open account
                    bank.createAccount();
                    break;
                case "c": // close account
                    bank.closeAccount();
                    break;
                case "g": // get balance
                    bank.checkBalance();
                    break;
                case "d": // deposit
                    bank.deposit();
                    break;
                case "w": // withdraw
                    bank.withdraw();
                    break;
                case "i": // account info
                    bank.printAccounts();
                    break;
                case "q": // quit
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;
            }
        }
    }
}
