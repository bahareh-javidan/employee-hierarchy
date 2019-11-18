package com.momenton.codechallenge.service;

import com.momenton.codechallenge.domain.Employee;
import com.momenton.codechallenge.domain.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bahar Javidan
 * @since 2019-11-17
 */
public class EmployeeService {

    /**
     * returns CEO if exist
     *
     * @param employees list of employees
     * @return list of CEOs
     */
    public List<Employee> findCeo(List<Employee> employees) {
        return employees.stream().filter(x -> x.getManagerId() == 0).collect(Collectors.toList());
    }

    /**
     * returns subordinates based on a recursive function
     *
     * @param employees list of subordinates
     * @param manager   top manager, could be ceo or mid level manager
     */
    public void findSubordinate(List<Employee> employees, Employee manager) {
        List<Employee> subordinates = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getManagerId() == manager.getEmployeeId()) {
                subordinates.add(employee);
            }
        }
        if (subordinates.size() > 0) {
            ((Manager) manager).setEmployees(subordinates);
            for (Employee subordinate : subordinates) {
                findSubordinate(employees, subordinate);
            }
        }
    }
}
