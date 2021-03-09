package id.web.ilham.springnative.repositories;

import id.web.ilham.springnative.models.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    List<Employees> findAllByJobIdAndSalaryGreaterThan(String jobId, Integer minSalary);

    @Query(nativeQuery = true, value = "select * from employees e where e.salary >= :minSalary and e.salary <= :maxSalary")
    List<Employees> findAllSalaryBetween(Integer minSalary, Integer maxSalary);

    @Query(nativeQuery = true, value = "select e.* from employees e " +
            "join departments d on e.department_id = d.department_id " +
            "where d.department_name = ?1 and e.salary <= ?2")
    List<Employees> findAllEmployeesByDepartmentName(String departmentName, String maxSalary);

}
