package com.pluralsight.util;
import com.pluralsight.models.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    // Writes the receipt for the given order to a timestamped file
    public static void writeReceipt(Order order) {

        // Generate a timestamped filename
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

        String folderPath = "src/main/resources/receipts";
        String fileName = folderPath + "/receipt_" + timestamp + ".txt";

        // Ensure the receipts directory exists
        new File(folderPath).mkdirs();

        try (FileWriter writer = new FileWriter(fileName)) {

            // Write header and timestamp
            writer.write("=== ByteMeDeli Receipt ===\n");
            writer.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a")) + "\n\n");

            // Loop through and write each item in the order
            for (OrderItem item : order.getItems()) {

                // Write sandwich details
                if (item instanceof Sandwich sandwich) {

                    writer.write("- Sandwich: " + sandwich.getSize() + "\" on " + sandwich.getBreadType());

                    if (sandwich.isToasted()) {
                        writer.write(" (toasted)");

                    }
                    writer.write("\n");

                    // Display base sandwich price using Sandwich class method
                    writer.write(String.format("  Base Sandwich (%d\"): $%.2f%n", sandwich.getSize(), sandwich.getBasePrice()));
                    writer.write("   Included Sides: au jus, sauce\n");

                    // Write toppings: show premium with price, regular without
                    writer.write("  Toppings:\n");

                    for (Topping topping : sandwich.getToppings()) {
                        if (topping.isPremium()) {
                            double price = topping.getPrice(sandwich.getSize());

                            writer.write(String.format("  - %s ($%.2f)%n", topping.getName(), price));
                        } else {

                            writer.write("  - " + topping.getName() + "\n");

                        }

                    }

                    // Write total price for sandwich
                    writer.write(String.format("  Sandwich Total: $%.2f%n%n", sandwich.getPrice()));

                }

                // Write drink details
                else if (item instanceof Drink drink) {

                    writer.write(String.format("- Drink: %s %s ($%.2f)%n%n",

                            drink.getSize(),

                            drink.getName(),

                            drink.getPrice()));

                }

                // Write chips details
                else if (item instanceof Chips chips) {
                    writer.write(String.format("- Chips: %s%s ($%.2f)%n%n",
                            chips.getFlavor(),
                            chips.isSalted() ? " (Salted)" : " (Unsalted)",
                            chips.getPrice()));

                }
                else {
                    writer.write("- " + item.getOrderSummary() + " ($" + String.format("%.2f", item.getPrice()) + ")\n\n");
                }

            }
            // Write total order price
            writer.write("-----------------------------\n");
            writer.write(String.format("Total: $%.2f%n", order.getTotal()));
            writer.write("\nThank you for choosing ByteMeDeli!\n");

            // Confirm file creation
            System.out.println("✅ Receipt saved: " + fileName);
        } catch (IOException e) {
            System.err.println("❌ Failed to write receipt: " + e.getMessage());

        }

    }

}
