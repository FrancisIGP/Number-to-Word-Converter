package Converter;

import java.util.Scanner;
import java.text.NumberFormat;

public class Drivercode {

    public static final Scanner scan = new Scanner(System.in);
    public static final NumberFormat format = NumberFormat.getInstance();
    public static final Converter convert = new Converter();

    public static void main(String[] args) {

        long input_value = 0;
        format.setGroupingUsed(true);

        System.out.println("\n\033[33m[i]\033[0m Welcome to [Number-to-Word] Converter!\n");

        try {
            System.out.print("Enter an Integer: ");
            input_value = scan.nextLong();
        } catch (Exception e) {
            System.out.println("\n\033[31m[Error]\033[0m Input is either not an integer or exceeds 9.222 Qi. Please try again!\n");
            System.exit(0);
        }

        System.out.println("\nOutput:\n-------\n");
        System.out.println("Input Value : " + format.format(input_value));

        if (input_value < 0) {
            input_value = Math.abs(input_value);
            System.out.print("Word Format : Negative ");
        } else {
            System.out.print("Word Format : ");
        }
        
        long startRunTime = System.currentTimeMillis();
        Converter.converter(input_value);
        long endRunTime = System.currentTimeMillis();
        long timeElapsed = endRunTime - startRunTime;
        
        System.out.println("\n\n\033[33m[i]\033[0m Conversion Completed!");
        System.out.println("\033[33m[i]\033[0m Conversion Runtime: " + timeElapsed + "s\n");
    }
}