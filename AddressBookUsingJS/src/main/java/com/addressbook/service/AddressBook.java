package com.addressbook.service;

import com.addressbook.model.Contact;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private String name;
    private List<Contact> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added to " + name + " Address Book.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in " + name + " Address Book.");
        } else {
            System.out.println("\nContacts in " + name + " Address Book:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}
