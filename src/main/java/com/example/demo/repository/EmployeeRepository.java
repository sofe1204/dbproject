package com.example.demo.repository;

import com.example.demo.model.Employee.Employee;
import com.example.demo.model.Employee.EmployeeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeKey> {
}