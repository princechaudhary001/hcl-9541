package org.abesproject.hclhrms.Service;

import org.abesproject.hclhrms.entity.Employee;
import org.abesproject.hclhrms.repository.EmployeeRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImp {

    @Autowired
    private EmployeeRepoImp emprepo;

    public String addEmp() {
        Employee emp1 = new Employee(
                200,
                "Rahul",
                "FSD",
                "aman@gmail.com",
                "Active"
        );

        return emprepo.addEmp(emp1);
    }

    public String addEmpbulk(List<Employee> bulkEmp) {
        return emprepo.addEmpbulk(bulkEmp);
    }

    public List<Employee> getEmp() {
        return emprepo.getEmp();
    }
}