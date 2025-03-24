
/**
 * Class to handle different kinds of input.
 *
 * @Amy Hina
 * @2025-03-24
 */

import java.util.Scanner;

public class Input {
    public static String menu(String[] MENU_OPTS) {
        Scanner keyboard = new Scanner(System.in);
        String command = "";
        boolean found = false;

        while (!found) {
            System.out.println("What would you like to do?");
            command = keyboard.nextLine();
            command=command.toLowerCase();
            for (int i=0; i<MENU_OPTS.length; i++) {
                if (command.equals(MENU_OPTS[i])) {
                    found = true;
                }
            }
            if (!found) {
                System.out.println("That isn't a valid command!");
            }
        }
        return(command);
    }
    
    public static boolean yesNoInput (String yesNoText) {
        Scanner keyboard = new Scanner(System.in);
        final String[] YES_NO_INPUTS = {"yes", "y", "no", "n"};
        return(false);
    }
}
