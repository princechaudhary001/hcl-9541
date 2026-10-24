package org.abesproject.hclhrms.Service;

import org.abesproject.hclhrms.entity.Employee;
import org.abesproject.hclhrms.Repository.EmployeeRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {
    @Autowired
    private EmployeeRepoImp emp_repo;

    Employee emp1 = new Employee(200, "Rahul", "FSD", "Java", "ptomer40@yahoo.com");

    public String addEmp(){
        return emp_repo.addEmp(emp1);
    }

    public List<Employee> getEmp(){
        return emp_repo.getEmp();
    }

    public Employee getEmpById(){
        return emp_repo.getEmpbyId(200);
    }

    public String addBulkEmp(List<Employee> bulkEmp){
        return emp_repo.addEmpbulk(bulkEmp);
    }

    public String deletebyID(long emp_id) {
        return emp_repo.deletebyID(emp_id);
    }

    public String updatebyId(long emp_id, Employee updatedEmp) {
        return emp_repo.updatebyId(emp_id, updatedEmp);
    }
}