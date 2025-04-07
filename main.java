
/**
 * Main class for my AS91906 project.
 *
 * @Amy Hina
 * @2025-04-07
 */

/**
 * todo: add the total information to be printed at program close, and maybe optional
 * configuration options n stuff
 * 
 * fuarrkkkkk and i need to switch address and acc number in the ordering cuz i didnt
 * look at the csv properly cuz im dumb - done that
 * 
 * i also want to make the program accept command line arguments to customize the csv to use
 * if i have time for it - done that
 */

public class main {
    public static void main(String args[]) {
        final String[] MENU_OPTS = {"o", "c", "g", "d", "w", "i", "q"};
        String csv; // = "bankData.csv";
        String option;
        boolean running = true;
        
        // take command line argument for optional different csv to use
        if (args.length == 1) {
            System.out.println("Using \"" + args[args.length] + "\" as CSV file.");
            csv = args[args.length];
        } else if (args.length > 1) {
            System.out.println("Too many arguments, please only input one CSV to use.");
            System.out.println("Falling back to default CSV (bankData.csv).");
            csv = "bankData.csv";
        } else {
            csv = "bankData.csv";
        }
        
        Bank bank = new Bank();
        bank.readCSV(csv);

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
                    // run whatever method i make to print the total info stuff
                    //System.out.println("Goodbye");
                    bank.calculator();
                    System.out.println("Total money in bank: $" + bank.getTotalMoney());
                    bank.writeCSV(csv);
                    System.exit(0);
                    break;
            }
        }
    }
}
