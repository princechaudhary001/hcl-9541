package org.example.fielddi;

import org.springframework.stereotype.Component;

@Component
public class Employee {

    private final Address address;

    // Single constructor: @Autowired is not needed
    public Employee(Address address) {
        this.address = address;
    }

    public String displayAddress() {
        return address.getAddress();
    }
}