package org.abesproject.hclhrms.Controller;

import org.abesproject.hclhrms.Service.EmpServiceImp;
import org.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmpServiceImp empServiceImp;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to ABES Hrms";
    }

    @GetMapping("/addEmp")
    public String addnewEmployee() {
        return empServiceImp.addEmp();
    }

    @GetMapping("/getEmp")
    public List<Employee> getEmp() {
        return empServiceImp.getEmp();
    }

    @PostMapping("/addEmpbulk")
    public String addEmpbulk(@RequestBody List<Employee> bulkEmp) {
        return empServiceImp.addEmpbulk(bulkEmp);
    }
}