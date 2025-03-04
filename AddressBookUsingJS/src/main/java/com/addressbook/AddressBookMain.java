package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.AddressBook;

import java.util.*;

public class AddressBookMain {
    private static final Map<String, AddressBook> addressBooks = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Display All Address Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAddressBook();
                    break;
                case 2:
                    selectAddressBook();
                    break;
                case 3:
                    displayAllAddressBooks();
                    break;
                case 4:
                    System.out.println("Exiting Address Book System...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void createAddressBook() {
        System.out.print("Enter Address Book name: ");
        String name = scanner.nextLine();
        if (addressBooks.containsKey(name)) {
            System.out.println("Address Book with this name already exists.");
        } else {
            addressBooks.put(name, new AddressBook(name));
            System.out.println("Address Book '" + name + "' created successfully.");
        }
    }

    private static void selectAddressBook() {
        System.out.print("Enter Address Book name to select: ");
        String name = scanner.nextLine();
        AddressBook selectedBook = addressBooks.get(name);

        if (selectedBook == null) {
            System.out.println("Address Book not found.");
            return;
        }

        while (true) {
            System.out.println("\nManaging Address Book: " + name);
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Go Back");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact(selectedBook);
                    break;
                case 2:
                    selectedBook.displayContacts();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void addContact(AddressBook addressBook) {
        try {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("City: ");
            String city = scanner.nextLine();
            System.out.print("State: ");
            String state = scanner.nextLine();
            System.out.print("Zip Code: ");
            int zip = scanner.nextInt();
            System.out.print("Phone Number: ");
            long phoneNumber = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            System.out.print("Email: ");
            String email = scanner.nextLine();

            Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
            addressBook.addContact(contact);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayAllAddressBooks() {
        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books available.");
        } else {
            System.out.println("\nAvailable Address Books:");
            for (String name : addressBooks.keySet()) {
                System.out.println("- " + name);
            }
        }
    }
}
