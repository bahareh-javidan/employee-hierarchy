package com.momenton.codechallenge.dao;

import com.momenton.codechallenge.domain.Employee;
import com.momenton.codechallenge.domain.Manager;
import com.momenton.codechallenge.domain.Subordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bahar Javidan
 * @since 2019-11-17
 */
public class DataRetriever {

    /**
     * This method is used to create sample data.
     *
     * @return a list of employees
     */
    public List<Employee> getData() {
        List<Employee> employees = new ArrayList<>();
        Employee jamie = new Manager(150, "Jamie", 0);
        Employee allen = new Manager(100, "Allen", 150);
        Employee steve = new Manager(400, "Steve", 150);
        Employee matin = new Subordinate(220, "Matin", 100);
        Employee alex = new Subordinate(275, "Alex", 100);
        Employee david = new Subordinate(190, "David", 400);

        employees.add(jamie);
        employees.add(allen);
        employees.add(steve);
        employees.add(matin);
        employees.add(alex);
        employees.add(david);

        return employees;
    }
}
