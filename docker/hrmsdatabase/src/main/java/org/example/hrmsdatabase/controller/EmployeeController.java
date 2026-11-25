package org.example.hrmsdatabase.controller;

import org.example.hrmsdatabase.model.Employee;
import org.example.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        Employee employee = employeeService.login(email, password);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        }
        Map<String, String> err = new HashMap<>();
        err.put("message", "Invalid email or password");
        return ResponseEntity.badRequest().body(err);
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
