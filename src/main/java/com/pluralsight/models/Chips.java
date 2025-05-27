package com.pluralsight.models;

public class Chips implements OrderItem {
    private String flavor;
    private boolean salted;

    // Constructor
    public Chips(String flavor, boolean salted) {
        this.flavor = flavor;
        this.salted = salted;
    }

    // Getters
    public String getFlavor() {
        return flavor;
    }

    public boolean isSalted() {
        return salted;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getOrderSummary() {
        return (isSalted() ? "Salted" : "Unsalted") + " " + flavor + " Chips ($1.50)";
    }
}
