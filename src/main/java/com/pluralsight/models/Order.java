package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> items;

    // Constructor
    public Order() {
        this.items = new ArrayList<>();
    }

    // Adds an item to the order.
    public void addItem(OrderItem item) {
        items.add(item);
    }

    // Gets the full list of order items.
    public List<OrderItem> getItems() {
        return items;
    }

    // Calculates the total price for all items in the order.
    public double getTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getPrice)
                .sum();
    }



    // Returns full order summary
    public String getOrderSummary() {

        StringBuilder sb = new StringBuilder("Order Summary:\n");
        for (OrderItem item : items) {
            sb.append("-").append(item.getOrderSummary()).append("\n");
        }
        sb.append("================" + "\n");
        sb.append("Total: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}
