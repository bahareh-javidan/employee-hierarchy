package com.momenton.codechallenge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bahar Javidan
 * @since 2019-11-17
 */
public class Manager extends Employee {

    private List<Employee> employees = new ArrayList<>();

    public Manager(int employeeId) {
        super(employeeId, null, 0);
    }

    public Manager(int employeeId, String name, int managerId) {
        super(employeeId, name, managerId);
    }

    @Override
    public void print(int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("\t");
        }
        System.out.println(this.toString());
        indentation++;
        for (Employee employee : employees) {
            employee.print(indentation);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
