package id.web.ilham.springnative.controllers;

import id.web.ilham.springnative.models.entities.Employees;
import id.web.ilham.springnative.services.EmployeesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeesController {

    private EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    // Example URL : http://localhost:8080/api/v1/employee/findall1?jobId=IT_PROG&minSalary=5000
    @GetMapping("/findall1")
    public List<Employees> findAll1(@RequestParam String jobId, @RequestParam Integer minSalary) {
        return employeesService.findAllByJobIdAndSalaryGreaterThan(jobId, minSalary);
    }

    // Example URL : http://localhost:8080/api/v1/employee/findall2?minSalary=10000&maxSalary=20000
    @GetMapping("/findall2")
    public List<Employees> findAll2(@RequestParam Integer minSalary, @RequestParam Integer maxSalary) {
        return employeesService.findAllSalaryBetween(minSalary, maxSalary);
    }

    // Example URL : http://localhost:8080/api/v1/employee/findall3?departmentName=Shipping&maxSalary=3000
    @GetMapping("/findall3")
    public List<Employees> findAll3(@RequestParam String departmentName, @RequestParam String maxSalary) {
        return employeesService.findAllEmployeesByDepartmentName(departmentName, maxSalary);
    }
}
