package com.pluralsight.ui;

import com.pluralsight.models.Order;
import com.pluralsight.models.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Utility class for reusable UI methods
public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);
    private Order order = new Order();

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
        List<OrderItem> orderItems = new ArrayList<>();
        while (ordering) {
            printSeparator();
            System.out.println("🍽️ Order Menu");
            System.out.println("1. 🥪 Add Sandwich");
            System.out.println("2. 🧃 Add Drink");
            System.out.println("3. 🍟 Add Chips");
            System.out.println("4. 🧾 Checkout");
            System.out.println("5. ⭐ Add Signature Sandwich");
            System.out.println("6. ❌ Cancel Order");
            printSeparator();

            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {

                case "1":
                    SandwichScreen sandwichScreen = new SandwichScreen();
                    OrderItem sandwich = sandwichScreen.buildSandwich();
                    System.out.println("🥪 Sandwich added");
                    System.out.println(sandwich.getOrderSummary());
                    orderItems.add(sandwich);
                    break;

                case "2":
                    DrinkScreen drinkScreen = new DrinkScreen();
                    OrderItem drink = drinkScreen.buildDrink();
                    if (drink != null) {
                        orderItems.add(drink);
                        System.out.println("🧃 Drink added ");
                    }
                    break;

                case "3":
                    ChipsScreen chipsScreen = new ChipsScreen();
                    OrderItem chips = chipsScreen.buildChips();
                    if (chips != null) {
                        orderItems.add(chips);
                        System.out.println("🍟 Chips added");
                    }
                    break;

                case "4":
                    CheckoutScreen checkoutScreen = new CheckoutScreen();
                    orderItems.forEach(order::addItem);
                    checkoutScreen.displayCheckout(order);
                    orderItems.clear();
                    order.getItems().clear();
                    break;

                case "5":
                    SignatureSandwichScreen sss = new SignatureSandwichScreen();
                    OrderItem signatureSandwich = sss.buildSignatureSandwich();
                    orderItems.add(signatureSandwich);
                    break;

                case "6":
                    System.out.println("❌ Order canceled.");
                    orderItems.clear();
                    order = new Order();
                    ordering = false;
                    break;

                default:
                    System.out.println("⚠️ Invalid option. Please try again.");
            }

            pause(1000);

        }

    }


}
