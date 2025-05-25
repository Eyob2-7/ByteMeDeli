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
                    buildSandwich();
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

    private void buildSandwich() {
        printSeparator();
        System.out.println("🥪 Build Your Sandwich");

        boolean isSelected = false;
        String bread = null;
        String size = null;
        String meat = null;
        do {

            System.out.println("Select your bread:");
            System.out.println("1. White");
            System.out.println("2. Wheat");
            System.out.println("3. Sourdough");
            System.out.print("Choice: ");
            String breadChoice = scanner.nextLine().trim();
            switch (breadChoice) {
                case "1":
                    bread = "White";
                    break;
                case "2":
                    bread = "Wheat";
                    break;
                case "3":
                    bread = "Sourdough";
                    break;
                default:
            }
            isSelected = true;
            if (bread == null) {
                isSelected = false;
                System.out.println("⚠ Invalid bread selection.");
            }
        }
        while (!isSelected);
        //  Toasted
        System.out.println("Would you like the bread to be toasted?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Choice: ");
        String toasted = scanner.nextLine().trim();

        // Sandwich size
        do {
            System.out.println("Choose sandwich size:");
            System.out.println("1. 4 inch");
            System.out.println("2. 8 inch");
            System.out.println("3. 12 inch");
            System.out.print("Choice: ");
            String sizeChoice = scanner.nextLine().trim();

            switch (sizeChoice) {
                case "1":
                    size = "4 inch";
                    break;
                case "2":
                    size = "8 inch";
                    break;
                case "3":
                    size = "12 inch";
                    break;
                default:
            }
            isSelected = true;
            if (size == null) {
                isSelected = false;
                System.out.println("⚠ Invalid size selection.");
            }
        }
        while (!isSelected);

        // Choose meat
        do {
            System.out.println("Select meat:");
            System.out.println("1. Turkey");
            System.out.println("2. Ham");
            System.out.println("3. Roast Beef");
            System.out.println("4. No Meat");
            System.out.print("Choice: ");
            String meatChoice = scanner.nextLine();

            switch (meatChoice) {
                case "1":
                    meat = "Turkey";
                    break;
                case "2":
                    meat = "Ham";
                    break;
                case "3":
                    meat = "Roast Beef";
                    break;
                case "4":
                    meat = "No Meat";
                    break;
                default:
            }

            isSelected = true;
            if (meat == null) {
                isSelected = false;
                System.out.println("⚠ Invalid meat selection.");
            }
        }
        while (!isSelected);

        // Cheese
        System.out.println("Select cheese");
        System.out.println("1. Cheddar");
        System.out.println("2. Swiss");
        System.out.println("3. American");
        System.out.println("4. No Cheese");
        System.out.print("Choice: ");
        String cheeseChoice = scanner.nextLine().trim();
        String cheese = "No Cheese";
        switch (cheeseChoice) {
            case "1":
                cheese = "Cheddar";
                break;
            case "2":
                cheese = "Swiss";
                break;
            case "3":
                cheese = "American";
                break;
            case "4":
                cheese = "No Cheese";
                break;
            default:
        }
        // Other toppings
        System.out.println("Enter other toppings (comma-separated):");
        System.out.print("Toppings: ");
        String toppings = scanner.nextLine();

        // Sauce
        System.out.println("Choose a sauce:");
        System.out.println("1. Mayo");
        System.out.println("2. Mustard");
        System.out.println("3. Mayo and Mustard mix");
        System.out.println("4. No Sauce");
        System.out.print("Choice: ");
        String sauceChoice = scanner.nextLine();
        String sauce = "No Sauce";
        switch (sauceChoice) {
            case "1":
                sauce = "Mayo";
                break;
            case "2":
                sauce = " Mustard";
                break;
            case "3":
                sauce = "Mayo and Mustard mix";
                break;
            case "4":
                sauce = "No Sauce";
                break;
            default:
        }

        //  Summary output
        printSeparator();
        System.out.println("✅ Sandwich screen completed");
        System.out.println("Bread: " + bread);
        System.out.println("Toasted: " + (toasted.equals("1") ? "Yes" : "No"));
        System.out.println("Size: " + size);
        System.out.println("Meat: " + meat);
        System.out.println("Cheese: " + cheese);
        System.out.println("Toppings: " + toppings);
        System.out.println("Sauce: " + sauce);
        printSeparator();
    }


}
