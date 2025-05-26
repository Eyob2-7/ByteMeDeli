package com.pluralsight.ui;

import java.util.Scanner;

public class CheckoutScreen {
    private final Scanner scanner = new Scanner(System.in);

    public void displayCheckout() {
        System.out.println("🧾 Checkout");
        System.out.println("Here is a summary of your order:");
        // Simulated summary for now
        System.out.println("- Sandwich: ✔️");
        System.out.println("- Drink: ✔️");
        System.out.println("- Chips: ✔️");
        System.out.println("Total: $0");
        System.out.println("\n1. ✅ Confirm Order");
        System.out.println("2. Cancel, go back to the menu");
        System.out.print("Choice: ");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1":
                System.out.println("\n✅ Thank you! Your order has been confirmed.");
                break;
            case "2":
                System.out.println("\n↩ Order canceled Returning to order menu...");
                break;
            default:
                System.out.println("⚠ Invalid input. Returning to menu...");
        }
    }
}
