package com.addressbook.model;

import java.util.regex.Pattern;

public class Contact {
    private String firstName, lastName, address, city, state, email;
    private int zip;
    private long phoneNumber;

    // Regular Expressions for Validation
    private static final String NAME_REGEX = "^[A-Z][a-zA-Z]{2,}$"; // First letter uppercase, min 3 chars
    private static final String ADDRESS_REGEX = "^[a-zA-Z0-9\\s]{4,}$"; // Min 4 chars
    private static final String ZIP_REGEX = "^[1-9][0-9]{5}$"; // 6-digit zip code
    private static final String PHONE_REGEX = "^[6-9][0-9]{9}$"; // 10-digit phone number starting with 6-9
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"; // Valid email pattern

    public Contact(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber, String email) {
        if (!Pattern.matches(NAME_REGEX, firstName)) {
            throw new IllegalArgumentException("Invalid First Name: Should start with uppercase and have at least 3 letters.");
        }
        if (!Pattern.matches(NAME_REGEX, lastName)) {
            throw new IllegalArgumentException("Invalid Last Name: Should start with uppercase and have at least 3 letters.");
        }
        if (!Pattern.matches(ADDRESS_REGEX, address)) {
            throw new IllegalArgumentException("Invalid Address: Minimum 4 characters.");
        }
        if (!Pattern.matches(ADDRESS_REGEX, city)) {
            throw new IllegalArgumentException("Invalid City: Minimum 4 characters.");
        }
        if (!Pattern.matches(ADDRESS_REGEX, state)) {
            throw new IllegalArgumentException("Invalid State: Minimum 4 characters.");
        }
        if (!Pattern.matches(ZIP_REGEX, String.valueOf(zip))) {
            throw new IllegalArgumentException("Invalid Zip: Should be a 6-digit number.");
        }
        if (!Pattern.matches(PHONE_REGEX, String.valueOf(phoneNumber))) {
            throw new IllegalArgumentException("Invalid Phone: Should be a 10-digit number starting with 6-9.");
        }
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("Invalid Email: Enter a valid email.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getZip() { return zip; }
    public long getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }

    // Setters with Validation
    public void setAddress(String address) {
        if (!Pattern.matches(ADDRESS_REGEX, address)) {
            throw new IllegalArgumentException("Invalid Address: Minimum 4 characters.");
        }
        this.address = address;
    }

    public void setCity(String city) {
        if (!Pattern.matches(ADDRESS_REGEX, city)) {
            throw new IllegalArgumentException("Invalid City: Minimum 4 characters.");
        }
        this.city = city;
    }

    public void setState(String state) {
        if (!Pattern.matches(ADDRESS_REGEX, state)) {
            throw new IllegalArgumentException("Invalid State: Minimum 4 characters.");
        }
        this.state = state;
    }

    public void setZip(int zip) {
        if (!Pattern.matches(ZIP_REGEX, String.valueOf(zip))) {
            throw new IllegalArgumentException("Invalid Zip: Should be a 6-digit number.");
        }
        this.zip = zip;
    }

    public void setPhoneNumber(long phoneNumber) {
        if (!Pattern.matches(PHONE_REGEX, String.valueOf(phoneNumber))) {
            throw new IllegalArgumentException("Invalid Phone: Should be a 10-digit number starting with 6-9.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("Invalid Email: Enter a valid email.");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " | " + city + ", " + state + " | " + phoneNumber + " | " + email;
    }
}
