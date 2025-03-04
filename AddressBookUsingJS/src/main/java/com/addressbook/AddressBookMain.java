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
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Go Back");
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
                    editContact(selectedBook);
                    break;
                case 4:
                    deleteContact(selectedBook);
                    break;
                case 5:
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

    private static void editContact(AddressBook addressBook) {
        System.out.print("Enter First Name of Contact to Edit: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name of Contact to Edit: ");
        String lastName = scanner.nextLine();

        Optional<Contact> contactOptional = addressBook.findContactByName(firstName, lastName);
        if (contactOptional.isEmpty()) {
            System.out.println("Contact not found.");
            return;
        }

        Contact oldContact = contactOptional.get();

        try {
            System.out.println("Enter new details (leave blank to keep unchanged):");

            System.out.print("New Address: ");
            String address = scanner.nextLine();
            System.out.print("New City: ");
            String city = scanner.nextLine();
            System.out.print("New State: ");
            String state = scanner.nextLine();
            System.out.print("New Zip Code: ");
            String zipInput = scanner.nextLine();
            System.out.print("New Phone Number: ");
            String phoneInput = scanner.nextLine();
            System.out.print("New Email: ");
            String email = scanner.nextLine();

            // Use old values if fields are left blank
            String newAddress = address.isEmpty() ? oldContact.getAddress() : address;
            String newCity = city.isEmpty() ? oldContact.getCity() : city;
            String newState = state.isEmpty() ? oldContact.getState() : state;
            int newZip = zipInput.isEmpty() ? oldContact.getZip() : Integer.parseInt(zipInput);
            long newPhone = phoneInput.isEmpty() ? oldContact.getPhoneNumber() : Long.parseLong(phoneInput);
            String newEmail = email.isEmpty() ? oldContact.getEmail() : email;

            Contact newContact = new Contact(oldContact.getFirstName(), oldContact.getLastName(),
                    newAddress, newCity, newState, newZip, newPhone, newEmail);
            addressBook.editContact(oldContact, newContact);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteContact(AddressBook addressBook) {
        System.out.print("Enter First Name of Contact to Delete: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name of Contact to Delete: ");
        String lastName = scanner.nextLine();

        Optional<Contact> contactOptional = addressBook.findContactByName(firstName, lastName);
        if (contactOptional.isEmpty()) {
            System.out.println("Contact not found.");
            return;
        }

        Contact contact = contactOptional.get();
        addressBook.deleteContact(contact);
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
