package com.abes.hrms.controller;

import com.abes.hrms.model.DemoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private DemoEmployee demoEmployee;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Springboot Application";
    }

    @GetMapping("/add")
    public int sum(@RequestParam(defaultValue = "0") int a,
                   @RequestParam(defaultValue = "0") int b) {
        return demoEmployee.add(a, b);
    }

    @GetMapping("/sqrt")
    public double getSquareRoot(@RequestParam(defaultValue = "0") double d) {
        return demoEmployee.squareRoot(d);
    }
}