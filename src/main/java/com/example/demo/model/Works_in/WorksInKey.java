package com.example.demo.model.Works_in;

import com.example.demo.model.Employee.Employee;
import com.example.demo.model.Firm;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class WorksInKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="firm_id")
    private Firm firm;

    public WorksInKey(Employee employee, Firm firm) {
        this.employee = employee;
        this.firm = firm;
    }

    public WorksInKey() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }
}
