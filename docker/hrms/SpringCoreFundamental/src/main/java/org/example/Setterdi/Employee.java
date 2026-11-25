package org.example.Setterdi;

public class Employee { //[cite: 3]
    private Address address; //[cite: 3]

    public void setAddress(Address address) {
        this.address = address;
    }

    public void displayAddress() {
        if (address != null) {
            System.out.println("Employee Address City: " + address.getCity());
        } else {
            System.out.println("Address is null");
        }
    }
}