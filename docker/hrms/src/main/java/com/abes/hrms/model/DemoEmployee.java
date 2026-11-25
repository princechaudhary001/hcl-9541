package com.abes.hrms.model;

import com.abes.hrms.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoEmployee {

    @Autowired
    private EmpRepo empRepo;

    public int add(int a, int b) {
        return empRepo.add(a, b);
    }

    public double squareRoot(double d) {
        return empRepo.squareroot(d);
    }
}