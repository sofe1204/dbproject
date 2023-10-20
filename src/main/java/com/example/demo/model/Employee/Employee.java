package com.example.demo.model.Employee;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="employee")
public class Employee {

    @EmbeddedId
    EmployeeKey employeeKey;

    Integer employee_id;

    public Employee(EmployeeKey employeeKey, Integer employee_id) {
        this.employeeKey = employeeKey;
        this.employee_id = employee_id;
    }

    public Employee() {

    }

    public EmployeeKey getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(EmployeeKey employeeKey) {
        this.employeeKey = employeeKey;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }
}