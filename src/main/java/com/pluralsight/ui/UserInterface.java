package com.pluralsight.ui;

// Utility class for reusable UI methods
public class UserInterface {

    // Prints a visual separator line
    void printSeparator() {
        System.out.println("==================================================");
    }

    // Pauses execution for a specified duration
    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
