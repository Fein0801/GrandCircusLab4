package co.grandcircus;

import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	// hard coded maximum value, might change later
	int max = 1000;
	int num = 0;

	String choice = "yes";
	do {
	    // Prompts user for a number (has a maximum)
	    System.out.println("Please enter a whole number (do not exceed " + formatInt(max) + "): ");
	    num = scan.nextInt();

	    scan.nextLine(); // clear line here

	    if (num > max) {
		continue; // Repeat prompt if user exceeds max value
	    }
	    printPowerTable(num);

	    System.out.println("Continue? (yes/no)"); // TODO Add validation for "yes" AND "no"
	    choice = scan.next();

	} while (choice.equalsIgnoreCase("yes"));

	System.out.println();

	// Picks a random number between 10 and 15
	int randomNum = (int) (Math.random() * 6) + 10;

	System.out.printf("Here is a multiplication table for all the numbers between 1 and %d:  %n", randomNum);
	printMultTable(randomNum);

	System.out.println("Goodbye.");

	scan.close();
    }

    private static void printPowerTable(int num) {
	printFormattedLine("Number", "Squared", "Cubed");
	printFormattedLine("======", "=======", "=====");
	for (int i = 1; i <= num; i++) {
	    int squaredNum = (int) Math.pow(i, 2);
	    int cubedNum = (int) Math.pow(i, 3);

	    printFormattedLine(formatInt(i), formatInt(squaredNum), formatInt(cubedNum));
	}
    }

    private static void printFormattedLine(String str1, String str2, String str3) {
	// ensures strings take up 15 spaces in between them
	System.out.printf("%-15s%-15s%-15s%n", str1, str2, str3);
    }

    // prints a multiplication table from 1 to a
    private static void printMultTable(int a) {
	for (int i = 1; i <= a; i++) {
	    for (int j = 1; j <= a; j++) {
		System.out.printf("%-5s|", i * j + " ");
	    }
	    System.out.println();
	}
    }

    public static String formatInt(int num) {
	return String.format("%,d", num);
    }

}
