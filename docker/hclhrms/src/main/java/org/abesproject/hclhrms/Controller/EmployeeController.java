package org.abesproject.hclhrms.Controller;

import org.abesproject.hclhrms.Service.EmployeeServiceImp;
import org.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp empServiceImp;

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
        return empServiceImp.addBulkEmp(bulkEmp); // Fixed: passed bulkEmp argument to match service method
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam long id) {
        return empServiceImp.deletebyID(id);
    }

    @PutMapping("/updateById")
    public String updateById(@RequestParam long id, @RequestBody Employee updatedEmp) {
        return empServiceImp.updatebyId(id, updatedEmp);
    }
}