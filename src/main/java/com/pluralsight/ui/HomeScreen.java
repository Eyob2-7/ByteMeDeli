package com.pluralsight.ui;

import java.util.Scanner;

// Displays the home screen with menu options
public class HomeScreen {
    private final Scanner scanner = new Scanner(System.in);
    private final UserInterface ui = new UserInterface();

    // Main loop for home screen
    public void display() {
        boolean running = true;

        while (running) {

            // Display title and menu

            ui.printSeparator();

            System.out.println("  Welcome to ByteMe Deli!  ");

            System.out.println("     🥪  🧃  🍟");

            ui.printSeparator();

            System.out.println("1. 🛒 New Order");

            System.out.println("2. ❌ Exit");

            ui.printSeparator();

            // Get user input

            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            // Handle selection

            switch (input) {

                case "1":
                    UserInterface ui = new UserInterface();
                    System.out.println("🥪 Starting new order...");
                    ui.startOrder();
                    break;

                case "2":

                    System.out.println("👋 Goodbye!");

                    running = false;

                    break;

                default:

                    System.out.println("⚠️ Invalid input. Please try again.");

            }

            ui.pause(1000);
        }

    }
}
