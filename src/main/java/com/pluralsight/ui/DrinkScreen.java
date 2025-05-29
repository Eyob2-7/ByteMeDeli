package com.pluralsight.ui;

import com.pluralsight.models.Drink;

import java.util.Scanner;

public class DrinkScreen {
    private final Scanner scanner = new Scanner(System.in);

    public Drink buildDrink() {
        System.out.println("🥤 Choose Your Drink");

        // Drink Size
        String size = null;
        boolean isSelected = false;

        do {
            System.out.println("Select drink size:");
            System.out.println("1. Small");
            System.out.println("2. Medium");
            System.out.println("3. Large");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    size = "Small";
                    break;
                case "2":
                    size = "Medium";
                    break;
                case "3":
                    size = "Large";
                    break;
                default:
                    ;
            }

            isSelected = true;

            if (size == null) {

                isSelected = false;

                System.out.println("⚠ Invalid size selection. Please try again.");

            }

        } while (!isSelected);

        // Drink Flavor
        String flavor = null;
        isSelected = false;

        do {
            System.out.println("Select drink flavor:");
            System.out.println("1. Cola");
            System.out.println("2. Lemonade");
            System.out.println("3. Orange");
            System.out.println("4. Water");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    flavor = "Cola";
                    break;
                case "2":
                    flavor = "Lemonade";
                    break;
                case "3":
                    flavor = "Orange";
                    break;
                case "4":
                    flavor = "Water";
                    break;
                default:
            }

            isSelected = true;
            if (flavor == null) {
                isSelected = false;
                System.out.println("⚠ Invalid flavor selection. Please try again.");
            }

        } while (!isSelected);

        System.out.println("✅ Drink selected: " + size + " " + flavor);

        return new Drink(flavor, size);
    }
}
