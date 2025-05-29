package com.pluralsight.ui;

import com.pluralsight.models.SignatureSandwich;

import java.util.Scanner;

public class SignatureSandwichScreen {
    private Scanner scanner = new Scanner(System.in);

    public SignatureSandwich buildSignatureSandwich() {
        System.out.println("⭐ Signature Sandwich Menu");
        SignatureSandwich signatureSandwich = new SignatureSandwich("");
        String sandwichName = "";
        boolean isSelected = false;
        do {
            System.out.println("Choose a Signature Sandwich:");
            System.out.println("1. blt (🥓 Bacon, 🧀 Cheddar, 🥬 Lettuce, 🍅 Tomato, 🧂 Ranch)");
            System.out.println("2. philly cheese steak (🥩 Steak, 🧀 American, 🫑 Peppers, 🧂 Mayo)");
            System.out.println("3. Go Back");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    sandwichName = "blt";
                    isSelected = true;
                    signatureSandwich.setName(sandwichName);
                    break;
                case "2":
                    sandwichName = "philly cheese steak";
                    isSelected = true;
                    signatureSandwich.setName(sandwichName);
                    break;
                case "3":
                    System.out.println("↩ Returning to order menu...");
                    return null;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (!isSelected);
        System.out.println("✅ " + sandwichName + " added to your order!");
        return signatureSandwich;
    }
}
