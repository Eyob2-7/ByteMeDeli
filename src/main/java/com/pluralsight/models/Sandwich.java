package com.pluralsight.models;

import java.util.List;
import java.util.stream.Collectors;

public class Sandwich implements OrderItem {
    private int size;
    private List<Topping> toppings; // List of selected toppings.
    private String breadType;
    private boolean isToasted;

    public Sandwich(int size, boolean isToasted, String breadType, List<Topping> toppings) {
        this.size = size;
        this.isToasted = isToasted;
        this.breadType = breadType;
        this.toppings = toppings;
    }

    // Gets bread type
    public String getBreadType() {
        return breadType;
    }

    // Gets sandwich size
    public int getSize() {
        return size;
    }

    // Checks if sandwich is toasted
    public boolean isToasted() {
        return isToasted;
    }

    // Gets the list of toppings
    public List<Topping> getToppings() {
        return toppings;
    }

    // Adds all toppings
    public void addTopping(List<Topping> toppings) {
        this.toppings = toppings;
    }

    // Calculates the total price of the sandwich including premium toppings
    @Override
    public double getPrice() {
        double basePrice;

        switch (size) {
            case 4:
                basePrice = 5.50;
                break;
            case 8:
                basePrice = 7.00;
                break;
            case 12:
                basePrice = 8.50;
                break;
            default:
                System.out.println("Invalid sandwich size.");
                return 0.0;
        }
        double toppingPrice =
                toppings.stream()
                        .mapToDouble(t -> t.getPrice(size))
                        .sum();
        return basePrice + toppingPrice;
    }

    // Returns only the base price
    public double getBasePrice() {
        return switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };
    }


    // Returns summary of the sandwich order
    @Override
    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" sandwich on ").append(breadType).append("bread");
        if (isToasted) {
            sb.append(" (toasted)");
        }
        sb.append("\nToppings:");

        if (toppings.isEmpty()) {
            sb.append(" none");
        } else {
            String toppingList = toppings.stream()
                    .map(t -> "-" + t.getName())
                    .collect(Collectors.joining("\n"));

            sb.append("\n").append(toppingList);
        }
        sb.append("\nTotal: $").append(String.format("%.2f", getPrice()));

        return sb.toString();
    }
}
