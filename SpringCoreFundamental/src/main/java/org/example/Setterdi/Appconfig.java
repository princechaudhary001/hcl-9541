package org.example.Setterdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //[cite: 2]
public class Appconfig {

    @Bean
    public Address address(){ //[cite: 2]
        return new Address(); //[cite: 2]
    }

    @Bean
    public Employee emp(Address address){ //[cite: 2]
        Employee emp1 = new Employee(); //[cite: 2]
        emp1.setAddress(address); //[cite: 2]
        return emp1; //[cite: 2]
    }
}