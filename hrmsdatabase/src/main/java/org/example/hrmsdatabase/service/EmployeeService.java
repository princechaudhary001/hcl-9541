package org.example.hrmsdatabase.service;

import org.example.hrmsdatabase.model.Employee;
import org.example.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. Add Multiple Employees
    public String createnewEmployee() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Aman", "aman@gmail.com", "HR", 200000));
        employees.add(new Employee("Rahul", "rahul@gmail.com", "IT", 150000));
        employees.add(new Employee("Priya", "priya@gmail.com", "Finance", 180000));

        employeeRepository.saveAll(employees);
        return "3 Employees added successfully";
    }

    // 2. Find Employee By ID
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // 3. Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 4. Delete Employee By ID
    public String deleteEmployeeById(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "Employee not found with ID: " + id;
    }

    // 5. Update Employee By ID
    public Employee updateEmployeeById(long id, Employee newEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            employee.setName(newEmployee.getName());
            employee.setEmail(newEmployee.getEmail());
            employee.setDepartment(newEmployee.getDepartment());
            employee.setSalary(newEmployee.getSalary());
            return employeeRepository.save(employee);
        }
        return null;
    }
}