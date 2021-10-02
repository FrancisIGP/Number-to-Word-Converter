package Converter;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Drivercode {

    public static final Scanner scan = new Scanner(System.in);
    public static final Converter convert = new Converter();

    public static void main(String[] args) {

        clearScreen();

        System.out.println("\n\033[33m[i]\033[0m Welcome to [Number-to-Word] Converter!\n");

        System.out.print("Enter an Integer: ");
        String input_value = scan.nextLine().trim();
        input_value = input_value.replace(",", "");

        if (isInteger(input_value) == false) {
            System.out.println("\n\033[31m[Error]\033[0m Input is not or has an Integer. Please try again!\n");
            System.exit(0);
        }

        int inputLength = input_value.toCharArray().length;
        if (inputLength > 207) {
            System.out.println("\n\033[31m[Error]\033[0m Input exceeds 10^3003 digits. Please try again!\n");
            System.exit(0);
        }

        System.out.println("\nOutput:\n-------\n");
        System.out.print("Input Value : ");
        
        formatInput(input_value);

        if (inputLength > 100) System.out.print("\n");

        if (input_value.charAt(0) == '-') {
            System.out.print("\nWord Format : Negative ");
            input_value = input_value.replace("-", "");
        } else {
            System.out.print("\nWord Format : ");
        }

        long startRunTime = System.currentTimeMillis();
        Converter.converter(input_value);
        long endRunTime = System.currentTimeMillis();
        long timeElapsed = endRunTime - startRunTime;
        // double seconds = (double) timeElapsed / 1_000_000_000;

        System.out.println("\n\n\033[33m[i]\033[0m Conversion Completed!");
        System.out.println("\033[33m[i]\033[0m Conversion Runtime: " + timeElapsed + " ms\n");

        scan.close();
    }

    public static boolean isInteger(String value) {
        int a = 0;
        if (value.charAt(0) == '-') a = 1;
    
        for (int i = a; i < value.length(); i++) {
            if (value.charAt(i) < '0' || value.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
 
    public static void formatInput(String input) {
        // Separate input with commas
        String answer = "";
        int a = 0;

        if (input.charAt(0) == '-') {
            a = 1;
            System.out.print("-");
        }

        for (int i = input.length() - 1, ctr = 0; i >= a; i--, ctr++) {
            if(ctr == 3){
                answer += ',';
                answer += input.charAt(i);
                ctr = 0;
            }else {
                answer += input.charAt(i);
            }
        }

        StringBuilder sb=new StringBuilder(answer);  
        sb.reverse();  
        System.out.print(sb);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}