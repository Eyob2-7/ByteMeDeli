package com.pluralsight.ui;

import com.pluralsight.models.Order;

import com.pluralsight.util.ReceiptWriter;

import java.util.Scanner;

public class CheckoutScreen {

    // Scanner for user input
    private final Scanner scanner = new Scanner(System.in);

    // Displays checkout and handles order confirmation
    public void displayCheckout(Order order) {

        System.out.println("🧾 Checkout");
        System.out.println("Here is a summary of your order:\n");

        // Show order summary
        System.out.println(order.getOrderSummary());

        // Prompt user to confirm or cancel
        System.out.println("\n1. ✅ Confirm Order");
        System.out.println("2. ❌ Cancel and go back to the menu");
        System.out.print("Choice: ");
        String choice = scanner.nextLine().trim();

        // Handle confirmation or cancellation
        switch (choice) {
            case "1":
                System.out.println("\n✅ Thank you! Your order has been confirmed.");
                ReceiptWriter.writeReceipt(order); // Save receipt
                break;

            case "2":
                System.out.println("\n↩ Order canceled. Returning to menu...");
                break;

            default:
                System.out.println("⚠ Invalid input. Returning to menu...");
        }
    }
}

