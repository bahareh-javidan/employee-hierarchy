package com.momenton.codechallenge.domain;

/**
 * @author Bahar Javidan
 * @since 2019-11-17
 */
public abstract class Employee {
    private int employeeId;
    private String name;
    private int managerId;

    public abstract void print(int indentation);

    public Employee(int employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(int employeeId, String name, int managerId) {
        this.employeeId = employeeId;
        this.name = name;
        this.managerId = managerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public int getManagerId() {
        return managerId;
    }
}
