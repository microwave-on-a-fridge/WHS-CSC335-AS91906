
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
            input = input.toLowerCase();
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
            input = input.toLowerCase();
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
                keyboard.next();
            } else if (input.length() > stringLength) {
                System.out.println("Too long, please enter something less than " + stringLength + " characters long.");
                keyboard.next();
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
                keyboard.next();
            } else if (input.length() > stringLength) {
                System.out.println("Too long, please enter something less than " + stringLength + " characters long.");
                keyboard.next();
            } else {
                for (int i=0; i<illegal.length; i++) {
                    if (input.contains(illegal[i])) {
                        duplicate = true;
                        System.out.println("Please make sure your input does not contain \"" + illegal[i] + "\".");
                        keyboard.next();
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
        boolean found = false;
        System.out.println(textPrompt);
        while (!found) {
            if (keyboard.hasNextInt()) {
                input = keyboard.nextInt();
                if (input == -1) {
                    System.out.println("Please enter something.");
                    keyboard.next();
                } else if (input > intLength) {
                    System.out.println("Too big, please enter something less than " + intLength + ".");
                    keyboard.next();
                } else {
                    found = true;
                }
            } else {
                System.out.println("Please enter a valid number.");
                keyboard.next();
            }
        }
        return(input);
    }

    public static double doub(String textPrompt, int doubleLength) {
        Scanner keyboard = new Scanner(System.in);
        double input = -1;
        boolean found = false;
        System.out.println(textPrompt);
        while (!found) {
            if (keyboard.hasNextDouble()) {
                input = keyboard.nextDouble();
                if (input == -1) {
                    System.out.println("Please enter something.");
                    keyboard.next();
                } else if (input > doubleLength) {
                    System.out.println("Too big, please enter something less than " + doubleLength + ".");
                    keyboard.next();
                } else {
                    found = true;
                }
            } else {
                System.out.println("Please enter a valid number.");
                keyboard.next();
            }
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
