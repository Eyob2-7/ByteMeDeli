package com.pluralsight.ui;

import java.util.Scanner;

// Utility class for reusable UI methods
public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);

    // Prints a visual separator line
    void printSeparator() {
        System.out.println("==================================================");
    }

    // Pauses execution for a specified duration
    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Displays the order menu and handles user input
    public void startOrder() {
        boolean ordering = true;

        while (ordering) {
            printSeparator();
            System.out.println("🍽️ Order Menu");

            System.out.println("1. 🥪 Add Sandwich");

            System.out.println("2. 🧃 Add Drink");

            System.out.println("3. 🍟 Add Chips");

            System.out.println("4. 🧾 Checkout");

            System.out.println("5. ❌ Cancel Order");

            printSeparator();

            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            switch (input) {

                case "1":

                    System.out.println("🥪 Sandwich added");

                    break;

                case "2":

                    System.out.println("🧃 Drink added ");

                    break;

                case "3":

                    System.out.println("🍟 Chips added");

                    break;

                case "4":

                    System.out.println("🧾 Checking out... ");

                    ordering = false;

                    break;

                case "5":

                    System.out.println("❌ Order canceled.");

                    ordering = false;

                    break;

                default:

                    System.out.println("⚠️ Invalid option. Please try again.");

            }

            pause(1000);

        }
    }


}
