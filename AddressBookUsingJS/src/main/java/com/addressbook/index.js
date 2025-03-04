const readline = require("readline-sync");
const AddressBook = require("./addressBook");
const Contact = require("./contact");

let myAddressBook = new AddressBook("Personal");

while (true) {
    console.log("\nAddress Book Menu:");
    console.log("1️.Add Contact");
    console.log("2️. Display Contacts");
    console.log("3️. Edit Contact");
    console.log("4️. Delete Contact");
    console.log("5️. Count Contacts");
    console.log("6️. Exit");

    let choice = readline.questionInt("Enter your choice: ");

    switch (choice) {
        case 1:
            try {
                let firstName = readline.question("Enter First Name: ");
                let lastName = readline.question("Enter Last Name: ");
                let address = readline.question("Enter Address: ");
                let city = readline.question("Enter City: ");
                let state = readline.question("Enter State: ");
                let zip = readline.question("Enter Zip Code: ");
                let phoneNumber = readline.question("Enter Phone Number: ");
                let email = readline.question("Enter Email: ");

                let newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                myAddressBook.addContact(newContact);
            } catch (error) {
                console.log(" Error: " + error.message);
            }
            break;
        case 2:
            myAddressBook.displayContacts();
            break;
        case 3:
            let editFirstName = readline.question("Enter First Name to Edit: ");
            let editLastName = readline.question("Enter Last Name to Edit: ");

            if (myAddressBook.findContactByName(editFirstName, editLastName)) {
                try {
                    let firstName = readline.question("Enter New First Name: ");
                    let lastName = readline.question("Enter New Last Name: ");
                    let address = readline.question("Enter New Address: ");
                    let city = readline.question("Enter New City: ");
                    let state = readline.question("Enter New State: ");
                    let zip = readline.question("Enter New Zip Code: ");
                    let phoneNumber = readline.question("Enter New Phone Number: ");
                    let email = readline.question("Enter New Email: ");

                    let updatedContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    myAddressBook.editContact(editFirstName, editLastName, updatedContact);
                } catch (error) {
                    console.log(" Error: " + error.message);
                }
            } else {
                console.log(" Contact not found.");
            }
            break;
        case 4:
            let deleteFirstName = readline.question("Enter First Name to Delete: ");
            let deleteLastName = readline.question("Enter Last Name to Delete: ");
            myAddressBook.deleteContact(deleteFirstName, deleteLastName);
            break;
        case 5:
            console.log("Total Contacts:", myAddressBook.getContactCount());
            break;
        case 6:
            console.log(" Exiting...");
            process.exit();
        default:
            console.log("Invalid choice, please try again.");
    }
}
