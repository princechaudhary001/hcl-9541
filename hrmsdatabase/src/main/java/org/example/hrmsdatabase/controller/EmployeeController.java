package org.example.hrmsdatabase.controller;

import org.example.hrmsdatabase.model.Employee;
import org.example.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String hello() {
        return "Welcome to Employee Management System";
    }

    @PostMapping("/addEmp")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmp() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/findbyid/{id}")
    public Employee getEmpById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable long id) {
        return employeeService.deleteEmployeeById(id);
    }
}