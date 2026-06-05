package com.employee.employee.repository;

import com.employee.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmpEmail(String email);
    Optional<Employee> findByEmpCode(String code);
    Optional<Employee> findByEmpEmailOrEmpCode(String email, String code);
}
