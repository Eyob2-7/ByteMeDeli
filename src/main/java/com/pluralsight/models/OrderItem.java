package com.pluralsight.models;

/**
 * The OrderItem interface defines the required behavior
 * for all items that can be added to an order, such as
 * Sandwich, Drink, or Chips.
 */
public interface OrderItem {

    // Returns the price of the item
    double getPrice();

    // Returns a summary of the item
    String getOrderSummary();
}
