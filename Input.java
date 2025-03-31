
/**
 * Class to handle different kinds of input.
 *
 * @Amy Hina
 * @2025-04-01
 */

import java.util.Scanner;

public class Input {
    public static String menu(String textPrompt, String[] MENU_OPTS) {
        Scanner keyboard = new Scanner(System.in);
        String command = "";
        boolean found = false;

        while (!found) {
            System.out.println(textPrompt);
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
    
    public static String string(String textPrompt, int stringLength) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        System.out.println(textPrompt);
        while (input.equals("") || input.length() > stringLength) {
            input = keyboard.nextLine();
        }
        return(input);
    }
    
    public static int integer(String textPrompt, int intLength) {
        Scanner keyboard = new Scanner(System.in);
        int input = -1;
        System.out.println(textPrompt);
        while (input == -1 || input > intLength || input < 0) {
            input = keyboard.nextInt();
        }
        return(input);
    }
    
    public static double doub(String textPrompt, int intLength) {
        Scanner keyboard = new Scanner(System.in);
        double input = -1;
        System.out.println(textPrompt);
        while (input == -1 || input > intLength || input < 0) {
            input = keyboard.nextDouble();
        }
        return(input);
    }
    
    public static boolean yesNoInput (String textPrompt) {
        Scanner keyboard = new Scanner(System.in);
        final String[] YES_NO_INPUTS = {"yes", "y", "no", "n"};
        return(false); // finish this
    }
}
