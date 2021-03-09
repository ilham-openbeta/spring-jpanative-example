package id.web.ilham.springnative.services;

import id.web.ilham.springnative.models.entities.Employees;
import id.web.ilham.springnative.repositories.EmployeesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> findAllByJobIdAndSalaryGreaterThan(String jobId, Integer minSalary){
        return employeesRepository.findAllByJobIdAndSalaryGreaterThan(jobId, minSalary);
    }

    public List<Employees> findAllSalaryBetween(Integer minSalary, Integer maxSalary){
        return employeesRepository.findAllSalaryBetween(minSalary, maxSalary);
    }

    public List<Employees> findAllEmployeesByDepartmentName(String departmentName, String maxSalary){
        return employeesRepository.findAllEmployeesByDepartmentName(departmentName, maxSalary);
    }

}
