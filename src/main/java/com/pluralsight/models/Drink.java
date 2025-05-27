package com.pluralsight.models;

public class Drink implements OrderItem {
    private String name;
    private String size;

    // Constructor
    public Drink(String name, String size) {
        this.name = name;
        this.size = size;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                System.out.println("Error");
                return 0.0;

        }
    }

    @Override
    public String getOrderSummary() {
        return size + " " + name + " ($" + String.format("%.2f", getPrice()) + ")";
    }

}
