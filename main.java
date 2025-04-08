
/**
 * Main class for my AS91906 project.
 *
 * @Amy Hina
 * @2025-04-09
 */

public class main {
    public static void main(String args[]) {
        final String[] MENU_OPTS = {"o", "c", "g", "d", "w", "i", "q"};
        String read;
        String write;
        String option;
        boolean running = true;
        
        // take command line argument for optional different csv to use
        if (args.length == 1) {
            System.out.println("Using \"" + args[args.length] + "\" as CSV file.");
            read = args[args.length];
            write = args[args.length];
        } else if (args.length == 2) { // if 2 csv are provided, read 1 and write to 2
            System.out.println("Reading from \"" + args[0] + "\" and writing to \"" + args[1] + "\".");
            read = args[0];
            write = args[1];
        } else if (args.length > 2) {
            System.out.println("Too many arguments, please only input one CSV to use.");
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
                    System.out.println("Total money in bank: $" + bank.getTotalMoney());
                    System.out.println("Net deposits/withdrawals: $" + bank.getTotalDifference());
                    bank.writeCSV(write);
                    System.out.println("Shutting down...");
                    System.exit(0);
                    break;
            }
        }
    }
}
