package com.pluralsight.data;

import com.pluralsight.models.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ToppingData {
    // Premium toppings (meats and cheeses with size-based pricing)
    public static List<Topping> getPremiumToppings() {
        List<Topping> toppings = new ArrayList<>();


        // Meats
        toppings.add(new Topping("Steak", "MEAT", true, Map.of(4, 1.00, 8, 2.00, 12, 3.00)));
        toppings.add(new Topping("Ham", "MEAT", true, Map.of(4, 1.00, 8, 2.00, 12, 3.00)));
        toppings.add(new Topping("Salami", "MEAT", true, Map.of(4, 1.00, 8, 2.00, 12, 3.00)));
        toppings.add(new Topping("Roast Beef", "MEAT", true, Map.of(4, 1.00, 8, 2.00, 12, 3.00)));
        toppings.add(new Topping("Chicken", "MEAT", true, Map.of(4, 1.00, 8, 2.00, 12, 3.00)));
        toppings.add(new Topping("Bacon", "MEAT", true, Map.of(4, 1.00, 8, 2.00, 12, 3.00)));
        toppings.add(new Topping("Extra Meat", "MEAT", true, Map.of(4, 0.50, 8, 1.00, 12, 1.50)));

        // Cheeses
        toppings.add(new Topping("American", "CHEESE", true, Map.of(4, 0.75, 8, 1.50, 12, 2.25)));
        toppings.add(new Topping("Provolone", "CHEESE", true, Map.of(4, 0.75, 8, 1.50, 12, 2.25)));
        toppings.add(new Topping("Cheddar", "CHEESE", true, Map.of(4, 0.75, 8, 1.50, 12, 2.25)));
        toppings.add(new Topping("Swiss", "CHEESE", true, Map.of(4, 0.75, 8, 1.50, 12, 2.25)));
        toppings.add(new Topping("Extra Cheese", "CHEESE", true, Map.of(4, 0.30, 8, 0.60, 12, 0.90)));

        return toppings;
    }

    // Regular toppings (free for all sizes)
    public static List<Topping> getRegularToppings() {
        List<Topping> toppings = new ArrayList<>();

        // Veggies
        toppings.add(new Topping("Lettuce", "VEGGIE", false, null));
        toppings.add(new Topping("Peppers", "VEGGIE", false, null));
        toppings.add(new Topping("Onions", "VEGGIE", false, null));
        toppings.add(new Topping("Tomatoes", "VEGGIE", false, null));
        toppings.add(new Topping("Jalapeños", "VEGGIE", false, null));
        toppings.add(new Topping("Cucumbers", "VEGGIE", false, null));
        toppings.add(new Topping("Pickles", "VEGGIE", false, null));
        toppings.add(new Topping("Guacamole", "VEGGIE", false, null));
        toppings.add(new Topping("Mushrooms", "VEGGIE", false, null));

        // Sauces
        toppings.add(new Topping("Mayo", "SAUCE", false, null));
        toppings.add(new Topping("Mustard", "SAUCE", false, null));
        toppings.add(new Topping("Ketchup", "SAUCE", false, null));
        toppings.add(new Topping("Ranch", "SAUCE", false, null));
        toppings.add(new Topping("Thousand Island", "SAUCE", false, null));
        toppings.add(new Topping("Vinaigrette", "SAUCE", false, null));

        return toppings;
    }

    // Helper method to get a specific premium topping by name
    public static Topping getPremiumTopping(String name) {
        return getPremiumToppings().stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static Topping getRegularTopping(String name) {
        return getRegularToppings().stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


    // Combined list
    public static List<Topping> getAllToppings() {
        List<Topping> all = new ArrayList<>();
        all.addAll(getPremiumToppings());
        all.addAll(getRegularToppings());
        return all;
    }
}
