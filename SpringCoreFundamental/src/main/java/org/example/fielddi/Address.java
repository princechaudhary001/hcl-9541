package org.example.fielddi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

    private final String value;

    public Address(@Value("${employee.address:New Arya Nagar, Ghaziabad}") String value) {
        this.value = value;
    }

    public String getAddress() {
        return value;
    }
}