package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void writeReceipt(Order order) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String folderPath = "src/main/resources/receipts";
        String fileName = folderPath + "/receipt_" + timestamp + ".txt";

        // To ensure folder exists
        new File(folderPath).mkdirs();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("=== ByteMeDeli Receipt ===\n");
            writer.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a")) + "\n\n");
            writer.write(order.getOrderSummary());
            writer.write("\nTotal: $" + String.format("%.2f", order.getTotal()));
            writer.write("\n\nThank you for choosing ByteMeDeli!\n");

            System.out.println("✅ Receipt saved: " + fileName);

        } catch (IOException e) {
            System.err.println("❌ Failed to write receipt: " + e.getMessage());
        }
    }
}
