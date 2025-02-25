import java.util.Scanner;

public class PalindromeChecker{
    public static String reverse(String word){
        String result = "";
        word = word.toLowerCase();
        for (int i = (word.length() - 1); i >= 0; i--){
            result = result + word.charAt(i);
        }
        return result;

    }

    public static void main(String[] args) {
        while (true) {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter word/phrase, enter 0 to exit: ");
            String input = myScanner.nextLine();
            // compareTo returns 0 when both objects compared are equal
            if (input.length() <=1) {
                if (input.compareTo("0") == 0) {
                    System.out.println("Program will now exit.");
                    break;
                }
                System.out.println("Please, enter a sequence that involves at least 2 characters.");
                continue;
            }
            String reversed = reverse(input);
            if (input.toLowerCase().compareTo(reversed) == 0) {
                System.out.println("'" + input.toLowerCase() + "' is a palindrome!");
            } else {
                System.out.println("'" + input.toLowerCase() + "' is not a palindrome as it is '" + reversed + "' when reversed.");
            }
        }
    }
}