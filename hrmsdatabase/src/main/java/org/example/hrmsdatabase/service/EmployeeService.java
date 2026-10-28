package org.example.hrmsdatabase.service;

import org.example.hrmsdatabase.model.Employee;
import org.example.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee login(String email, String password) {
        return employeeRepository.findByEmail(email)
                .filter(emp -> emp.getPassword() != null && emp.getPassword().equals(password))
                .orElse(null);
    }

    public String deleteEmployeeById(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "Employee not found with ID: " + id;
    }
}
