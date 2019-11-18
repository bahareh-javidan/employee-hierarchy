package com.momenton.codechallenge;

import com.momenton.codechallenge.domain.Employee;
import com.momenton.codechallenge.domain.Manager;
import com.momenton.codechallenge.domain.Subordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bahar Javidan
 * @since 2019-11-17
 */
public class EmployeeFixture {

    public static List<Employee> createEmployeesFixture() {
        List<Employee> employees = new ArrayList<>();

        Employee allen = new Manager(100, "Allen", 150);
        Employee steve = new Manager(400, "Steve", 150);
        Employee matin = new Subordinate(220, "Matin", 100);
        Employee alex = new Subordinate(275, "Alex", 100);
        Employee david = new Subordinate(190, "David", 400);

        employees.add(allen);
        employees.add(steve);
        employees.add(matin);
        employees.add(alex);
        employees.add(david);
        return employees;
    }

    public static Manager createCeoFixture() {
        return new Manager(150, "Jamie", 0);
    }

    public static List<Employee> createEmployeesWithCeoFixture() {
        List<Employee> employees = createEmployeesFixture();
        employees.add(createCeoFixture());
        return employees;
    }

    public static List<Employee> createEmployeesWithMultipleCeoFixture() {
        List<Employee> employees = createEmployeesWithCeoFixture();
        employees.add(new Manager(200, "Tim", 0));
        return employees;
    }
}
