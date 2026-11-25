package com.abes.hrms.repository;

import java.time.LocalDate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepImp implements EmpRepo {

    @Override
    public double squareroot(double d) {
        return Math.sqrt(d);
    }

    @Override
    public String empDate() {
        return LocalDate.now().toString();
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}