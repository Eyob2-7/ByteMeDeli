package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class OrderTest {

    @Test
    void getTotal_shouldReturnSumOfAllOrderItems() {

        // Arrange
        Sandwich sandwich = new Sandwich(
                8,
                true,
                "White",

                List.of(
                        new Topping("Ham", "MEAT", true, Map.of(4, 1.00, 8, 2.00, 12, 3.00), false),
                        new Topping("Lettuce", "VEGGIE", false, null, false)
                )
        );

        Drink drink = new Drink("Cola", "Medium");
        Chips chips = new Chips("BBQ", true);
        Order order = new Order();
        order.addItem(sandwich);
        order.addItem(drink);
        order.addItem(chips);

        // Act
        double actual = order.getTotal();
        double expected = 7.00 + 2.00 + 2.50 + 1.50;

        // Assert
        assertEquals(expected, actual);

    }

}