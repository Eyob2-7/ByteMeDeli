package com.pluralsight.models;

import com.pluralsight.data.ToppingData;

import java.util.ArrayList;
import java.util.List;

public class SignatureSandwich extends Sandwich {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SignatureSandwich(String name) {
        super(8, true, "White", new ArrayList<>());
        this.name = name;
        switch (name.toLowerCase()) {
            case "blt":
                addTopping(List.of(
                        ToppingData.getPremiumTopping("Bacon"),
                        ToppingData.getPremiumTopping("Cheddar"),
                        ToppingData.getRegularTopping("Lettuce"),
                        ToppingData.getRegularTopping("Tomato"),
                        ToppingData.getRegularTopping("Ranch")

                ));
                break;
            case "philly cheese steak":
                addTopping(List.of(
                        ToppingData.getPremiumTopping("Steak"),
                        ToppingData.getPremiumTopping("American"),
                        ToppingData.getRegularTopping("Peppers"),
                        ToppingData.getRegularTopping("Mayo")
                ));
                break;
            default:
        }
    }

    @Override
    public String getOrderSummary() {
        return "[Signature] " + name + "\n" + super.getOrderSummary();
    }
}
