import java.util.Scanner;
import java.util.ArrayList;

public class StringToArrayConverter {

    public static ArrayList<Character> convert_to_array(String string_given){
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < string_given.length(); i++) {
            result.add(string_given.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a string to be converted to array, or 0 to exit:");
            String input = myScanner.nextLine();
            // compareTo() returns 0 when both are equal
            if (input.compareTo("0") == 0) {
                System.out.println("Program now exiting.");
                break;
            }

            ArrayList<Character> output = new ArrayList<>();
            output = convert_to_array(input);

            for (Character character : output) {
                System.out.println(character);
            }
        }
    }
}
