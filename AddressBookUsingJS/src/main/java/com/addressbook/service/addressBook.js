class AddressBook {
    constructor(name) {
        this.name = name;
        this.contacts = [];
    }

    addContact(contact) {
        let isDuplicate = this.contacts.some(c => 
            c.firstName.toLowerCase() === contact.firstName.toLowerCase() && 
            c.lastName.toLowerCase() === contact.lastName.toLowerCase()
        );
    
        if (isDuplicate) {
            console.log("Duplicate entry! Contact already exists.");
        } else {
            this.contacts.push(contact);
            console.log("Contact added successfully.");
        }
    }
    displayContacts() {
        if (this.contacts.length === 0) {
            console.log(" No contacts found.");
        } else {
            console.log(`\n Contacts in ${this.name} Address Book:`);
            this.contacts.forEach(contact => console.log(contact.toString()));
        }
    }

    findContactByName(firstName, lastName) {
        return this.contacts.find(contact => 
            contact.firstName.toLowerCase() === firstName.toLowerCase() && 
            contact.lastName.toLowerCase() === lastName.toLowerCase()
        );
    }

    editContact(firstName, lastName, newContact) {
        let index = this.contacts.findIndex(contact => 
            contact.firstName.toLowerCase() === firstName.toLowerCase() && 
            contact.lastName.toLowerCase() === lastName.toLowerCase()
        );

        if (index !== -1) {
            this.contacts[index] = newContact;
            console.log("Contact updated successfully.");
        } else {
            console.log("Contact not found.");
        }
    }

    deleteContact(firstName, lastName) {
        let index = this.contacts.findIndex(contact => 
            contact.firstName.toLowerCase() === firstName.toLowerCase() && 
            contact.lastName.toLowerCase() === lastName.toLowerCase()
        );

        if (index !== -1) {
            this.contacts.splice(index, 1);
            console.log(" Contact deleted successfully.");
        } else {
            console.log(" Contact not found.");
        }
    }

    getContactCount() {
        return this.contacts.reduce((count) => count + 1, 0);
    }
}

module.exports = AddressBook;
