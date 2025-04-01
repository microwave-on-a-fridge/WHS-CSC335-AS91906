
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
        String input = "";
        boolean found = false;

        while (!found) {
            System.out.println(textPrompt);
            input = keyboard.nextLine();
            input=input.toLowerCase();
            for (int i=0; i<MENU_OPTS.length; i++) {
                if (input.equals(MENU_OPTS[i])) {
                    found = true;
                }
            }
            if (!found) {
                System.out.println("That isn't a valid command!");
            }
        }
        return(input);
    }
    
        public static int numCheck(String textPrompt, String[] MENU_OPTS) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        int output = -1;
        boolean found = false;

        while (!found) {
            System.out.println(textPrompt);
            input = keyboard.nextLine();
            input=input.toLowerCase();
            for (int i=0; i<MENU_OPTS.length; i++) {
                if (input.equals(MENU_OPTS[i])) {
                    output = i;
                    found = true;
                }
            }
            if (!found) {
                System.out.println("That isn't a valid command!");
            }
        }
        return(output);
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
    
    public static boolean yesNo (String textPrompt, boolean defaultYes) {
        Scanner keyboard = new Scanner(System.in);
        final String[] YES_NO_INPUTS = {"yes", "no", "y", "n", ""};
        System.out.println(textPrompt);
        int input = numCheck("", YES_NO_INPUTS);
        
        // i think there is a nicer way for me to do this but ill figure it out later
        
        // actually yeah im pretty sure this just straight up doesnt work ill fix later
        if (defaultYes && input == YES_NO_INPUTS.length) {
            return(true);
        } else if (!defaultYes && input == YES_NO_INPUTS.length) {
            return(false);
        }
        if (input % 2 == 0) {
            return(true);
        } else {
            return(false);
        }
    }
}
