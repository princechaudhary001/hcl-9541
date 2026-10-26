package org.example.hrmsdatabase.controller;

import org.example.hrmsdatabase.model.Employee;
import org.example.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Welcome Page
    @GetMapping("/")
    public String hello() {
        return "Welcome to Employee Management System";
    }

    // 1. Add Employees
    @GetMapping("/addEmp")
    public String addnewEmployee() {
        return employeeService.createnewEmployee();
    }

    // 2. Get All Employees
    @GetMapping("/getAll")
    public List<Employee> getAllEmp() {
        return employeeService.getAllEmployees();
    }

    // 3. Find Employee By ID
    @GetMapping("/findbyid/{id}")
    public Employee getEmpById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    // 4. Delete Employee By ID
    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable long id) {
        return employeeService.deleteEmployeeById(id);
    }

    // 5. Update Employee By ID
    @PutMapping("/updateEmp/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }
}