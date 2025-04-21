// File: Main.java

import java.util.ArrayList;
import java.util.Scanner; // Import Scanner for user input

public class Main {
    private static Book[] inventory = new Book[20]; // Array to store books
    private static Scanner scanner = new Scanner(System.in); // Scanner object for reading user input

    // Fill inventory with 20 example books
    private static void initializeBooks() {

        for (int i = 0; i < inventory.length; i++) {

            inventory[i] = new Book(i + 1, "978-00000000" + i, "Book Title " + (i + 1));

        }


    }

    // Main loop for library operations
    private static void runLibraryApp() {
        boolean running = true; // Controls the loop
        while (running) {
            // Show main menu options
            System.out.println("\n--- Neighborhood Library ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine(); // Read user input

            // Using if-else instead of switch to control flow
            if (choice.equals("1")) {
                showAvailableBooks(); // Show books not checked out
            } else if (choice.equals("2")) {
                showCheckedOutBooks(); // Show checked out books
            } else if (choice.equals("3")) {
                running = false; // Exit the program
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        System.out.println("Goodbye!"); // Message after exiting
    }

    // Main method is the entry point of the program
    public static void main(String[] args) {
        initializeBooks(); // Fill the inventory with sample books
        runLibraryApp(); // Launch the library interface
    }


    // Show and allow checkout of available books
    private static void showAvailableBooks() {
        System.out.println("\n Available Books :");
        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.println(book); // Display book using toString
            }
        }

        // Prompt user for checkout
        System.out.print("\nEnter Book ID to check out or 'X' to return: ");
        String input = scanner.nextLine();

        // Use while loop for repeated attempts until exit
        while (!input.equalsIgnoreCase("X")) {
            boolean validId = false;
            for (Book book : inventory) {
                if (String.valueOf(book.getId()).equals(input) && !book.isCheckedOut()) {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    book.checkOut(name); // Check the book out
                    System.out.println("Book checked out successfully.");
                    validId = true;
                    break;
                }
            }
            if (!validId) {
                System.out.println("Invalid book ID or book not available.");
            }
            System.out.print("\nEnter Book ID to check out or 'X' to return: ");
            input = scanner.nextLine();
        }
    }

    // Show and allow check-in of checked out books
    private static void showCheckedOutBooks() {
        System.out.println("\n Checked Out Books :");
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.println(book.toCheckedOutString()); // Show full info
            }
        }

        // Prompt user for check-in
        System.out.print("\nEnter Book ID to check in or 'X' to return: ");
        String input = scanner.nextLine();

        // Use while loop for repeated attempts until exit
        while (!input.equalsIgnoreCase("X")) {
            boolean validId = false;
            for (Book book : inventory) {
                if (String.valueOf(book.getId()).equals(input) && book.isCheckedOut()) {
                    book.checkIn(); // Mark as returned
                    System.out.println("Book checked in successfully.");
                    validId = true;
                    break;
                }
            }
            if (!validId) {
                System.out.println("Invalid book ID or book is not checked out.");
            }
            System.out.print("\nEnter Book ID to check in or 'X' to return: ");
            input = scanner.nextLine();
        }
    }

    // Helper method to search book by ID
    private static Book findBookById(int id) {
        for (Book book : inventory) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null; // Return null if book not found

    }


}