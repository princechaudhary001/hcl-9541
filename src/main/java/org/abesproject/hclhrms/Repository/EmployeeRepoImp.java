package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepoImp implements EmployeeRepo {

    List<Employee> emplist = new ArrayList<>();

    @Override
    public String addEmp(Employee emp) {
        emplist.add(emp);
        return "Employee Added Successfully";
    }

    @Override
    public List<Employee> getEmp() {
        return emplist;
    }

    @Override
    public Employee getEmpbyId(long emp_id) {
        return null;
    }

    @Override
    public String deletebyID(long emp_id) {
        return "";
    }

    @Override
    public String updatebyId(long emp_id, Employee updatedEmp) {
        return "";
    }
    @Override
    public String addEmpbulk(List<Employee> bulkEmp) {
        emplist.addAll(bulkEmp);
        return "All Employees Added Successfully";
    }

}