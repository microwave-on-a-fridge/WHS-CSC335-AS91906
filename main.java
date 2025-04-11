
/**
 * Main class for my AS91906 project.
 * 
 * i pray that this project gets a good grade
 *
 * @Amy Hina
 * @2025-04-11
 */

public class main {
    public static void main(String[] args) {
        final String[] MENU_OPTS = {"o", "c", "l", "g", "d", "w", "q"};
        String read;
        String write;
        String option;
        boolean running = true;
        
        /* take command line argument for optional different csv to use */
        if (args.length == 1) {
            System.out.println("Using \"" + args[0] + "\" as CSV file.");
            read = args[0];
            write = args[0];
        } else if (args.length == 2) { // if 2 csv are provided, read csv 1 and write to csv2
            System.out.println("Reading from \"" + args[0] + "\" and writing to \"" + args[1] + "\".");
            read = args[0];
            write = args[1];
        } else if (args.length > 2) { // if too many args, fallback to default
            System.out.println("Too many arguments, please input either one CSV or two (one to read from one to write to).");
            System.out.println("Falling back to default CSV (bankData.csv).");
            read = "bankData.csv";
            write = "bankData.csv";
        } else {
            read = "bankData.csv";
            write = "bankData.csv";
        }
        
        Bank bank = new Bank();
        bank.readCSV(read);

        while (running) {
            System.out.println("Kawaii-Bank Online Banking");
            System.out.println("--------------------------");
            System.out.println("O: Open an account");
            System.out.println("C: Close an account");
            System.out.println("L: List accounts info");
            System.out.println("G: Get balance of an account");
            System.out.println("D: Deposit into an account");
            System.out.println("W: Withdraw from an account");
            System.out.println("Q: Quit");

            option = Input.menu("", MENU_OPTS);

            /* do different things based on different options */
            switch (option) {
                case "o": // open account
                    Input.clear();
                    bank.createAccount();
                    break;
                case "c": // close account
                    Input.clear();
                    bank.closeAccount();
                    break;
                case "l": // account info
                    Input.clear();
                    bank.printAccounts();
                    break;
                case "g": // get info
                    Input.clear();
                    bank.checkBalance();
                    break;
                case "d": // deposit
                    Input.clear();
                    bank.deposit();
                    break;
                case "w": // withdraw
                    Input.clear();
                    bank.withdraw();
                    break;
                case "q": // quit
                    System.out.println("Total money in bank: $" + String.format("%.2f", bank.getTotalMoney()));
                    System.out.println("Net deposits/withdrawals: $" + String.format("%.2f", bank.getTotalDifference()));
                    bank.writeCSV(write);
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
            }
        }
    }
}
