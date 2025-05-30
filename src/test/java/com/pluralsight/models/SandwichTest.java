package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
class SandwichTest {

    @Test
    void getPrice_shouldReturnBasePlusPremiumTopping() {

        // Arrange
        int size = 8;
        boolean isToasted = true;
        String breadType = "white";

        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Lettuce", "VEGGIE", false, null, false)); // regular topping
        toppings.add(new Topping("Steak", "MEAT", true, Map.of(4, 1.0, 8, 2.0, 12, 3.0), false));

        Sandwich sandwich = new Sandwich(size, isToasted, breadType, toppings);

        // Act
        double actualPrice = sandwich.getPrice();

        // Assert
        double expectedPrice = 7.00 + 2.00;
        assertEquals(expectedPrice, actualPrice);
    }
    @Test
    void getPrice_shouldIncludeExtraCheeseAsSeparatePremiumTopping(){

        //Arrange
        int size = 8;
        boolean isToasted = false;
        String breadType = "wheat";
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Cheese", "CHEESE", true, Map.of(4, 0.75, 8, 1.50, 12, 2.25),true));
        toppings.add(new Topping("Extra Cheese", "CHEESE", true, Map.of(4, 0.30, 8, 0.60, 12, 0.90), true));

        Sandwich sandwich = new Sandwich(size, isToasted, breadType, toppings);

        // Act
        double actualPrice = sandwich.getPrice();

        // Assert
        double expectedPrice = 7 + 1.50 + 0.60;
        assertEquals(expectedPrice, actualPrice);

    }

}