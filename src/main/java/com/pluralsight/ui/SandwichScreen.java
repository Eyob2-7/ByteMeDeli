package com.pluralsight.ui;

import com.pluralsight.data.ToppingData;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SandwichScreen {
    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input

    // Main method to build a sandwich
    public static Sandwich buildSandwich() {
        System.out.println("🥪 Build Your Sandwich");

        // Prompt user for bread choice
        String bread = selectOption("Select your bread:", List.of("White", "Wheat", "Sourdough"));

        // Ask if the user wants it toasted
        boolean isToasted = selectYesNo("Would you like the bread to be toasted?");

        // Select sandwich size
        int size = selectSize();

        // Collect all toppings
        List<Topping> allToppings = new ArrayList<>();
        allToppings.addAll(selectToppings("Choose premium toppings:", ToppingData.getPremiumToppings(), "Premium Toppings", size));
        allToppings.addAll(selectToppings("Choose regular toppings:", ToppingData.getRegularToppings(), "Regular Toppings", size));

        // Build and return the sandwich
        return new Sandwich(size, isToasted, bread, allToppings);

    }

    // method to select an option from a list
    private static String selectOption(String prompt, List<String> options) {

        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, options.get(i));
            }

            System.out.print("Choice: ");
            String input = scanner.nextLine().trim();

            try {
                int index = Integer.parseInt(input);

                if (index >= 1 && index <= options.size()) {
                    return options.get(index - 1);

                }

            } catch (NumberFormatException ignored) {

            }
            System.out.println("⚠ Invalid selection. Try again.");

        }

    }

    // Helper method to get yes/no response
    private static boolean selectYesNo(String question) {

        while (true) {
            System.out.println(question);
            System.out.println("1. Yes\n2. No");

            System.out.print("Choice: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("⚠ Invalid selection. Try again.");
            }
        }
    }

    // Helper method to select sandwich size
    private static int selectSize() {
        while (true) {
            System.out.println("Choose sandwich size:");
            System.out.println("1. 4 inch ($5.50)\n2. 8 inch ($7.00)\n3. 12 inch ($8.50)");

            System.out.print("Choice: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    return 4;
                case "2":
                    return 8;
                case "3":
                    return 12;
                default:
                    System.out.println("⚠ Invalid size. Try again.");
            }
        }
    }

    // Handles selecting toppings depending on whether they are premium or regular
    private static List<Topping> selectToppings(String prompt, List<Topping> availableToppings, String sectionLabel, int size) {

        List<Topping> selected = new ArrayList<>();
        System.out.println("\n=== " + sectionLabel + " ===");

        // Check if topping list is regular
        if (!availableToppings.stream().anyMatch(Topping::isPremium)) {

            selected.addAll(regularType(prompt, availableToppings, size));

        } else {

            // If premium, split by MEAT and CHEESE
            selected.addAll(selectByType(prompt + " (MEAT)", availableToppings, "MEAT", size));
            selected.addAll(selectByType(prompt + " (CHEESE)", availableToppings, "CHEESE", size));
        }
        return selected;
    }

    // Handles display and selection of regular toppings
    private static List<Topping> regularType(String prompt, List<Topping> availableToppings, int size) {
        List<Topping> selected = new ArrayList<>();
        boolean isRunning = true;

        // Separate toppings into veggie and sauce categories
        List<Topping> veggies = availableToppings.stream()
                .filter(t -> "VEGGIE".equalsIgnoreCase(t.getType()))
                .toList();

        List<Topping> sauces = availableToppings.stream()
                .filter(t -> "SAUCE".equalsIgnoreCase(t.getType()))
                .toList();

        // Combine all regular toppings for selection by index
        List<Topping> combined = new ArrayList<>();
        combined.addAll(veggies);
        combined.addAll(sauces);

        while (isRunning) {
            System.out.println(prompt);
            int index = 1;

            // Display veggie options
            if (!veggies.isEmpty()) {
                System.out.println("🥬 VEGGIES:");

                for (Topping t : veggies) {

                    System.out.printf("%d. %s%n", index++, t.getName());
                }
            }

            // Display sauce options
            if (!sauces.isEmpty()) {
                System.out.println("🧂 SAUCES:");

                for (Topping t : sauces) {
                    System.out.printf("%d. %s%n", index++, t.getName());
                }

            }

            // Prompt for user input
            System.out.println("0. Done");
            System.out.print("Choice (e.g., 1,3,5): ");

            String input = scanner.nextLine().trim();

            List<String> inputList = Arrays.stream(input.split(",")).toList();
            try {

                for (String i : inputList) {

                    int choice = Integer.parseInt(i);

                    if (choice == 0) {

                        isRunning = false;

                        break;

                    }

                    // Add selected topping to the result

                    if (choice >= 1 && choice <= combined.size()) {

                        Topping selectedTopping = combined.get(choice - 1);

                        selected.add(new Topping(

                                selectedTopping.getName(),

                                selectedTopping.getType(),

                                selectedTopping.isPremium(),

                                selectedTopping.getPriceBySize(),

                                false // no extra for regular

                        ));

                    } else {

                        System.out.println("⚠ Invalid choice.");

                    }

                }

            } catch (NumberFormatException e) {

                System.out.println("⚠ Please enter a valid number.");

            }

        }

        return selected;

    }

    // Handles premium topping selection grouped by type (MEAT or CHEESE)
    private static List<Topping> selectByType(String prompt, List<Topping> toppings, String type, int size) {

        List<Topping> selected = new ArrayList<>();
        List<Topping> filtered = toppings.stream()
                .filter(t -> type.equalsIgnoreCase(t.getType()))
                .toList();

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("\n🍽 " + prompt);

            // Display the toppings with prices

            for (int i = 0; i < filtered.size(); i++) {

                Topping t = filtered.get(i);
                if (t.getName().equalsIgnoreCase("Extra Meat") || t.getName().equalsIgnoreCase("Extra Cheese")) {
                    System.out.printf("   • %s ($%.2f)%n", t.getName(), t.getPrice(size)); // Just display without a number
                    continue; }// Don't make selectable

                System.out.printf("%d. %s ($%.2f)%n", i + 1, t.getName(), t.getPrice(size));

            }

            // Ask user for selection

            System.out.println("0. Done");

            System.out.print("Choice: ");

            String input = scanner.nextLine().trim();

            try {

                int choice = Integer.parseInt(input);

                if (choice == 0) {

                    isRunning = false;

                } else if (choice >= 1 && choice <= filtered.size()) {
                    // Get the selected topping
                    Topping base = filtered.get(choice - 1);

                    // Ask if user wants extra
                    boolean isExtra = false;
                    while (true) {
                        System.out.print("Would you like extra " + base.getName() + "? (y/n): ");
                        String extraInput = scanner.nextLine().trim().toLowerCase();
                        if (extraInput.equalsIgnoreCase("y")) {
                            isExtra = true;
                            break;
                        } else if (extraInput.equalsIgnoreCase("n")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("Invalid input. please enter 'y' or 'no'");
                        }

                    }

                    // Add topping to the list
                    selected.add(new Topping(
                            base.getName(),
                            base.getType(),
                            base.isPremium(),
                            base.getPriceBySize(),
                            isExtra

                    ));
                    if (isExtra) {
                        String name;
                        if (base.getType().equalsIgnoreCase("MEAT")) {
                            name = "Extra Meat";
                            selected.add(toppings.stream().filter(tt -> tt.getName().equalsIgnoreCase(name)).findFirst().orElse(null));
                        } else {
                            name = "Extra Cheese";
                            selected.add(toppings.stream().filter(tt -> tt.getName().equalsIgnoreCase(name)).findFirst().orElse(null));
                        }
                    }
                    isRunning = false;
                } else {
                    System.out.println("⚠ Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Please enter a valid number.");
            }
        }
        return selected;
    }
}

