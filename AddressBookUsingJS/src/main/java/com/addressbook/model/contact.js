class Contact {
    constructor(firstName, lastName, address, city, state, zip, phoneNumber, email) {
        if (!/^[A-Z][a-zA-Z]{2,}$/.test(firstName)) throw new Error("Invalid First Name");
        if (!/^[A-Z][a-zA-Z]{2,}$/.test(lastName)) throw new Error("Invalid Last Name");
        if (!/^.{4,}$/.test(address)) throw new Error("Invalid Address");
        if (!/^.{4,}$/.test(city)) throw new Error("Invalid City");
        if (!/^.{4,}$/.test(state)) throw new Error("Invalid State");
        if (!/^\d{6}$/.test(zip)) throw new Error("Invalid Zip Code");
        if (!/^\d{10}$/.test(phoneNumber)) throw new Error("Invalid Phone Number");
        if (!/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email)) throw new Error("Invalid Email");

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    toString() {
        return `${this.firstName} ${this.lastName}, ${this.address}, ${this.city}, ${this.state}, ${this.zip}, ${this.phoneNumber}, ${this.email}`;
    }
}

module.exports = Contact;
