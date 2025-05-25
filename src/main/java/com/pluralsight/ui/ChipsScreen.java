package com.pluralsight.ui;

import java.util.Scanner;

public class ChipsScreen {
    private final Scanner scanner = new Scanner(System.in);

    public void buildChips() {
        System.out.println("🍟 Add Chips");

        String chipsType = null;
        boolean isSelected = false;

        do {
            System.out.println("Select chip type:");
            System.out.println("1. Classic");
            System.out.println("2. Barbecue");
            System.out.println("3. Sour Cream & Onion");
            System.out.println("4. Jalapeño");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    chipsType = "Classic";
                    break;
                case "2":
                    chipsType = "Barbecue";
                    break;
                case "3":
                    chipsType = "Sour Cream & Onion";
                    break;
                case "4":
                    chipsType = "Jalapeño";
                    break;
                default:
                    ;
            }
            isSelected = true;
            if (chipsType == null) {
                isSelected = false;
                System.out.println("⚠ Invalid chip selection. Please try again.");
            }
        } while (!isSelected);
        System.out.println("✅ Chips selected: " + chipsType);
    }
}
