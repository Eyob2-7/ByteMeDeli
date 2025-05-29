package com.pluralsight.models;

import java.util.Map;

public class Topping {

    private String name;
    private String type; // MEAT, CHEESE, VEGGIE, SAUCE
    private boolean isPremium;
    private boolean isExtra;
    private Map<Integer, Double> priceBySize;        // base price
    private Map<Integer, Double> extraPriceBySize;   // extra price (if isExtra)

    // Full constructor for premium toppings

    public Topping(String name, String type, boolean isPremium, Map<Integer, Double> priceBySize, boolean isExtra) {
        this.name = name;
        this.type = type;
        this.isPremium = isPremium;
        this.priceBySize = priceBySize;
        this.extraPriceBySize = extraPriceBySize;
        this.isExtra = isExtra;

    }

    // Constructor for regular toppings (no size-based price)
    public Topping(String name, String type) {
        this.name = name;
        this.type = type;
        this.isPremium = false;
        this.priceBySize = null;
        this.extraPriceBySize = null;
        this.isExtra = false;
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

    public boolean isExtra() {
        return isExtra;
    }

    public Map<Integer, Double> getPriceBySize() {
        return priceBySize;
    }

    public Map<Integer, Double> getExtraPriceBySize() {
        return extraPriceBySize;
    }

    // Get the correct price for the size (takes extra pricing into account)
    public double getPrice(int size) {
        if (!isPremium || priceBySize == null) return 0.0;

        if (isExtra && extraPriceBySize != null) {
            return extraPriceBySize.getOrDefault(size, 0.0);

        }
        return priceBySize.getOrDefault(size, 0.0);
    }

    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }

}
