import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.pow;

public class simple_calculator {

    public static void main(String[] args){
        System.out.println("Welcome to the Simple Calculator script!");
        Scanner myScanner = new Scanner(System.in);
        while (true) {

            System.out.println("Enter a two-part calculation to be calculated: (or 'exit' to exit)");
            String input = myScanner.nextLine();
            if (input.toLowerCase().compareTo("exit") == 0){
                System.out.println("Goodbye!");
                break;
            }

            // Checks for anything other than digits, +,-,,/,*,^ and float points , and .
            Pattern myPattern = Pattern.compile("[^0-9-/*+^,.]");
            Matcher myMatcher = myPattern.matcher(input);
            if (myMatcher.find()){
                System.out.println("Your input contains non numeric characters.\nPermitted input is 0-9 and symbols ',' '.' '+' '-' '*' '/' '^'.");
                continue;
            }

            boolean float_found = input.contains(",") | input.contains(".");

            // Needs to be in dot form for parseFloat to work
            if (input.contains(",") ){
                input = input.replace(",", ".");
            }

            String[] parts_of_calculation = input.split("[-/*+^]");

            if (parts_of_calculation.length > 2) {
                System.out.println("Please enter a two part calculation.\nApp does not support multi-part calculation...yet.");
                continue;
            }

            ArrayList<Float> floats_to_calculate = new ArrayList<Float>();
            ArrayList<Integer> ints_to_calculate = new ArrayList<Integer>();

            for (String part : parts_of_calculation) {
                if (float_found) {
                    floats_to_calculate.add(Float.parseFloat(part));
                } else {
                    ints_to_calculate.add(Integer.parseInt(part));
                }
            }
            float result = 0.0f;

            if (input.contains("+")){
                if (float_found) {
                    result = floats_to_calculate.get(0) + floats_to_calculate.get(1);
                } else {
                    result = ints_to_calculate.get(0) + ints_to_calculate.get(1);
                }

            } else if (input.contains("-")) {
                if (float_found) {
                    result = floats_to_calculate.get(0) - floats_to_calculate.get(1);
                } else {
                    result = ints_to_calculate.get(0) - ints_to_calculate.get(1);
                }
            } else if (input.contains("*")) {
                if (float_found) {
                    result = floats_to_calculate.get(0) * floats_to_calculate.get(1);
                } else {
                    result = ints_to_calculate.get(0) * ints_to_calculate.get(1);
                }
            } else if (input.contains("/")) {
                if (float_found) {
                    result = floats_to_calculate.get(0) / floats_to_calculate.get(1);
                } else {
                    result = (float) ints_to_calculate.get(0) / (float) ints_to_calculate.get(1);
                }
            } else {
                if (float_found) {
                    result = (float) pow(floats_to_calculate.get(0), floats_to_calculate.get(1));
                } else {
                    result = (float)  pow(ints_to_calculate.get(0), ints_to_calculate.get(0));
                }
            }
            System.out.println("Result is: " + result);
        }
    }
}
