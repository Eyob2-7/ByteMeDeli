package com.pluralsight.ui;

import java.util.Scanner;

public class SignatureSandwichScreen {
    private Scanner scanner = new Scanner(System.in);

    public void buildSignatureSandwich() {
        System.out.println("⭐ Signature Sandwich Menu");
        String sandwichName = null;
        boolean isSelected = false;
        do {
            System.out.println("Choose a Signature Sandwich:");
            System.out.println("1. The Classic Club");
            System.out.println("2. The Veggie Delight");
            System.out.println("3. The Spicy Italian");
            System.out.println("4. Go Back");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    sandwichName = "Classic Club";
                    isSelected = true;
                    break;
                case "2":
                    sandwichName = "Veggie Delight";
                    isSelected = true;
                    break;
                case "3":
                    sandwichName = "Spicy Italian";
                    isSelected = true;
                    break;
                case "4":
                    System.out.println("↩ Returning to order menu...");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (!isSelected);
        System.out.println("✅ " + sandwichName + " added to your order!");
    }
}
