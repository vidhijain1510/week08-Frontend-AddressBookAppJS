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

    searchByCity(city) {
        let results = this.contacts.filter(contact => contact.city.toLowerCase() === city.toLowerCase());
        if (results.length === 0) {
            console.log(` No contacts found in ${city}.`);
        } else {
            console.log(`Contacts in ${city}:`);
            results.map(contact => console.log(contact.toString()));
        }
    }
    
    searchByState(state) {
        let results = this.contacts.filter(contact => contact.state.toLowerCase() === state.toLowerCase());
        if (results.length === 0) {
            console.log(` No contacts found in ${state}.`);
        } else {
            console.log(`Contacts in ${state}:`);
            results.map(contact => console.log(contact.toString()));
        }
    }

    viewByCity() {
        let cityGroups = this.contacts.reduce((result, contact) => {
            (result[contact.city] = result[contact.city] || []).push(contact);
            return result;
        }, {});
    
        console.log("\nPersons grouped by City:");
        Object.keys(cityGroups).forEach(city => {
            console.log(`\n${city}:`);
            cityGroups[city].map(contact => console.log(contact.toString()));
        });
    }
    
    viewByState() {
        let stateGroups = this.contacts.reduce((result, contact) => {
            (result[contact.state] = result[contact.state] || []).push(contact);
            return result;
        }, {});
    
        console.log("\nPersons grouped by State:");
        Object.keys(stateGroups).forEach(state => {
            console.log(`\n${state}:`);
            stateGroups[state].map(contact => console.log(contact.toString()));
        });
    }

    countByCity() {
        let cityCounts = this.contacts.reduce((result, contact) => {
            result[contact.city] = (result[contact.city] || 0) + 1;
            return result;
        }, {});
    
        console.log("\n📊 Contact count by City:");
        Object.entries(cityCounts).forEach(([city, count]) => {
            console.log(`🏙️ ${city}: ${count} contact(s)`);
        });
    }
    
    countByState() {
        let stateCounts = this.contacts.reduce((result, contact) => {
            result[contact.state] = (result[contact.state] || 0) + 1;
            return result;
        }, {});
    
        console.log("\n Contact count by State:");
        Object.entries(stateCounts).forEach(([state, count]) => {
            console.log(`🗺️ ${state}: ${count} contact(s)`);
        });
    }
    
    
}

module.exports = AddressBook;
