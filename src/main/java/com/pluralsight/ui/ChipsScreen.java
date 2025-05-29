package com.pluralsight.ui;

import com.pluralsight.models.Chips;

import java.util.Scanner;

public class ChipsScreen {

    private final Scanner scanner = new Scanner(System.in); // Scanner for input

    // Method to build and return a Chips object
    public Chips buildChips() {
        System.out.println("🍟 Add Chips");
        String chipsFlavor = null;
        boolean isSelected = false;

        // Select chip flavor
        do {
            System.out.println("Select chip flavor:");
            System.out.println("1. Classic");
            System.out.println("2. Barbecue");
            System.out.println("3. Sour Cream & Onion");
            System.out.println("4. Jalapeño");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": chipsFlavor = "Classic"; break;
                case "2": chipsFlavor = "Barbecue"; break;
                case "3": chipsFlavor = "Sour Cream & Onion"; break;
                case "4": chipsFlavor = "Jalapeño"; break;

            }

            isSelected = true;
            if (chipsFlavor == null) {
                isSelected = false;
                System.out.println("⚠ Invalid chip flavor. Please try again.");

            }

        } while (!isSelected);

        // Select if salted
        boolean isSalted = false;
        isSelected = false;
        do {

            System.out.println("Would you like your chips salted?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1": isSalted = true; isSelected = true; break;
                case "2": isSalted = false; isSelected = true; break;
                default:
                    System.out.println("⚠ Invalid selection. Please try again.");
            }

        } while (!isSelected);

        // Confirm chips selection
        String saltedText = isSalted ? "Salted" : "Unsalted";
        System.out.println("✅ Chips selected: " + chipsFlavor + " (" + saltedText + ")");

        // Return Chips object with flavor and salted status
        return new Chips(chipsFlavor, isSalted);
    }
}

