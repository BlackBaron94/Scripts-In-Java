import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void check_exit(int number){
        if (number == -1){
            System.out.println("Goodbye, then!");
            System.exit(-1);
        }
    }

    public static int get_range(){
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the desirable upper range (>5) for the random number (or -1 to exit):");
            try {
                int range = myScanner.nextInt();
                check_exit(range);
                if (range <= 5) {
                    System.out.println("Please provide a number greater than 5 to make the game interesting!");
                    continue;
                }
                return range;
            } catch (InputMismatchException e) {
                System.out.println("~~Invalid Input~~\nPlease enter an integer number to continue!");
                myScanner.nextLine();
            }
        }
    }

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
            ArrayList<Integer> numbers_tried = new ArrayList<>();

            while (!found) {
                int guess = get_guess(range);

                for (Integer number_tried : numbers_tried) {
                    if (guess == number_tried) {
                        System.out.println("You've already tried that number! Try another!");
                        // We want to remind the user if this number is higher or lower
                        // so attempts will be increased, so we decrease it here so it remains the same!
                        attempts--;
                        // No need to continue checking our list!
                        break;
                    }
                }
                numbers_tried.add(guess);
                if (guess < randomNum) {
                    System.out.println("Try higher!");
                    attempts++;
                } else if (guess > randomNum) {
                    System.out.println("Try lower!");
                    attempts++;
                } else {
                    System.out.println("Congratulations! You found the number in " + attempts+ " attempts!!");
                    found = true;
                }
            }
        }
    }
}
