package org.abesproject.hclhrms.Repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepoImp implements org.abesproject.hclhrms.repository.EmployeeRepo {

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
        boolean status = false;
        if(getEmpbyId(emp_id)!=null){
            status = emplist.removeIf(e->e.getEmp_id()==emp_id); // Fixed: removed duplicate 'boolean' declaration
        }
        if(status){
            return "Employee deleted Sussfully"; // Fixed: added missing semicolon
        }
        return "Employee is not registered with id "+ emp_id;
    }

    @Override
    public String updatebyId(long emp_id, Employee updatedEmp) {
        Employee existImpEmp = getEmpbyId(emp_id);
        if(existImpEmp!=null){
            existImpEmp.setEmail("abc@gmail.com"); // Fixed: corrected variable name and added semicolon
        }
        return "Employee updated sucessfully";
    }

    @Override
    public String addEmpbulk(List<Employee> bulkEmp) {
        emplist.addAll(bulkEmp);
        return "All Employees Added Successfully";
    }
}