import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessTheNumberGame {

    // Made a method for reusability, exits when -1 is detected in input
    public static void check_exit(int number){
        if (number == -1){
            System.out.println("Goodbye, then!");
            System.exit(-1);
        }
    }

    // Grabs upper range, checks InputMismatch and that it's >5 to make game interesting
    public static int get_range(){
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the desirable upper range (>5) for the random number (or -1 to exit):");
            try {
                int range = myScanner.nextInt();
                check_exit(range);
                if (range <= 5) {
                    System.out.println("Please provide a number greater than 5 to make the game interesting!");
                    // Skips return range; and goes to next iteration
                    continue;
                }
                return range;
            } catch (InputMismatchException e) {
                System.out.println("~~Invalid Input~~\nPlease enter an integer number to continue!");
                // Clears input by receiving it as string so that exception doesn't loop
                myScanner.nextLine();
            }
        }
    }

    // Grabs guess from player, checks that it's within range
    public static int get_guess(int range){
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Try to guess the random number! (or -1 to exit)");
            try {
                int answer = myScanner.nextInt();
                check_exit(answer);
                if (answer > range | answer < 0) {
                    System.out.println("Please enter a valid integer between 0 and " + range + "!");
                    continue;
                }
                return answer;
            } catch (InputMismatchException e) {
                System.out.println("~~Invalid Input~~\nPlease enter an integer number to continue!\n"
                + "Range is from 0 to " + range + "!");
                myScanner.nextLine();
            }
        }
    }

    public static void main(String[] args){
        System.out.println("\n~~~Hello and welcome to~~~ \n\n"
                + "//                       \\\\\n"
                + "||'GUESS THE NUMBER' GAME||"
                + "\n\\\\                       //\n");

        while (true) {
            int range = get_range();

            // Returns Float from 0,0(inclusive) to 1,0(exclusive)
            // e.g. range 15 makes (15+1)*float return up to 15.9
            // which when typecasted into int becomes 15
            int randomNum = (int) (Math.random() * (range + 1));
            System.out.println("A random number has been chosen between the range 0 and " + range + "!");

            int attempts = 0;
            boolean found = false;
            // An ArrayList for numbers the user has already tried,
            // out of range numbers aren't added as they're filtered by get_guess
            ArrayList<Integer> numbers_tried = new ArrayList<>();

            while (!found) {
                int guess = get_guess(range);

                /*  This boolean exists to make sure user gets a reminder if
                    they've tried the number again, without getting their attempts
                    increased! */
                boolean retried_number = false;
                for (Integer number_tried : numbers_tried) {
                    if (guess == number_tried) {
                        System.out.println("You've already tried that number! Try another!");
                        // Number has been retried
                        retried_number = true;
                        break;
                    }
                }
                // Added only if it hasn't been tried (and added) before
                if (! retried_number) {
                    numbers_tried.add(guess);
                }
                // User gets hint anyway
                if (guess < randomNum) {
                    System.out.println("Try higher!");
                    // Has their attempt count increased only if not retried_number!
                    if (! retried_number) {
                        attempts++;
                    }
                } else if (guess > randomNum) {
                    System.out.println("Try lower!");
                    if (! retried_number) {
                        attempts++;
                    }

                } else {
                    attempts++;
                    found = true;
                    if (attempts == 1){
                        System.out.println("Congratulations!!! You found the number in JUST ONE attempt!!!!\n"
                                + "The chance of this occurring is " + (1.0f / (range + 1.0f) * 100.0f) + "%!!");
                        // This print appears for chances < 5%
                        if (range > 19) {
                            System.out.println("That is EXTREMELY LUCKY!!!!!");
                        }
                        // This continue skips normal congratulatory print for both range > and < 19 cases
                        continue;
                    }
                    System.out.println("Congratulations! You found the number in "
                                    + attempts
                                    + " attempts!!");
                }
            }
        }
    }
}