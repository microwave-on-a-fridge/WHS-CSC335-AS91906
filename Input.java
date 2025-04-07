
/**
 * Class to handle different kinds of input.
 *
 * @Amy Hina
 * @2025-04-07
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
                System.out.println("Invalid input.");
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
                System.out.println("Invalid input.");
            }
        }
        return(output);
    }
    
    public static String string(String textPrompt, int stringLength) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        System.out.println(textPrompt);
        boolean found = false;
        while (!found) {
            input = keyboard.nextLine();
            if (input.equals("")) {
                System.out.println("Please enter something.");
            } else if (input.length() > stringLength) {
                System.out.println("Too long, please enter something less than " + stringLength + " characters long.");
            } else {
                found = true;
            }
        }
        return(input);
    }
    
    public static String stringNoChar(String textPrompt, int stringLength, String[] illegal) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        System.out.println(textPrompt);
        boolean found = false;
        boolean duplicate = false;
        while (!found) {
            input = keyboard.nextLine();
            if (input.equals("")) {
                System.out.println("Please enter something.");
            } else if (input.length() > stringLength) {
                System.out.println("Too long, please enter something less than " + stringLength + " characters long.");
            } else {
                for (int i=0; i<illegal.length; i++) {
                    if (input.contains(illegal[i])) {
                        duplicate = true;
                        System.out.println("Please make sure your input does not contain \"" + illegal[i] + "\".");
                    }
                }
                if (!duplicate) {
                    found = true;
                }
            }
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
    
    public static double doub(String textPrompt, int doubleLength) {
        Scanner keyboard = new Scanner(System.in);
        double input = -1;
        System.out.println(textPrompt);
        while (input == -1 || input > doubleLength || input < 0) {
            input = keyboard.nextDouble();
        }
        return(input);
    }
    
    public static boolean yesNo (String textPrompt, boolean defaultValue) {
        Scanner keyboard = new Scanner(System.in);
        final String[] YES_NO_INPUTS = {"yes", "no", "y", "n", ""};
        System.out.println(textPrompt);
        int input = numCheck("", YES_NO_INPUTS);
        if (defaultValue == true && input == YES_NO_INPUTS.length-1) {
            return(true);
        } else if (!defaultValue && input == YES_NO_INPUTS.length-1) {
            return(false);
        } else if (input % 2 == 0) {
            return(true);
        } else {
            return(false);
        }
    }
}
