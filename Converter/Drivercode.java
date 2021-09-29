package Converter;

import java.util.Scanner;
import java.text.NumberFormat;

public class Drivercode {

    public static final Scanner scan = new Scanner(System.in);
    public static final NumberFormat format = NumberFormat.getInstance();
    public static final Converter convert = new Converter();

    public static void main(String[] args) {

        format.setGroupingUsed(true);
        System.out.println("\n\033[33m[i]\033[0m Welcome to [Number-to-Word] Converter!\n");

        int input_value = 0;

        try {
            System.out.print("Enter an Integer: ");
            input_value = scan.nextInt();
        } catch (Exception e) {
            System.out.println("\n\033[31m[Error]\033[0m Input is either not an integer or exceeds 2.14 billion. Please try again!\n");
            System.exit(0);
        }

        System.out.println("\nOutput:\n-------\n");

        System.out.println("Input Value  : " + format.format(input_value));
        System.out.print("Word Format  : ");
        Converter.converter(input_value);

        System.out.println("\n\n\033[33m[i]\033[0m Conversion Completed!\n");
    }
}