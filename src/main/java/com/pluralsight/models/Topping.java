package com.pluralsight.models;

import java.util.Map;

public class Topping {
    private String name;
    private String type;
    private boolean isPremium;
    private Map<Integer, Double> priceBySize;

    // Constructor
    public Topping(String name, String type, boolean isPremium, Map<Integer, Double> priceBySize) {
        this.name = name;
        this.type = type;
        this.isPremium = isPremium;
        this.priceBySize = priceBySize;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public double getPrice(int size) {
        if (!isPremium || priceBySize == null) {
            return 0.0;
        }
        return priceBySize.getOrDefault(size, 0.0);

    }
}
