package com.momenton.codechallenge;

import com.momenton.codechallenge.dao.DataRetriever;
import com.momenton.codechallenge.domain.Employee;
import com.momenton.codechallenge.service.EmployeeService;

import java.util.List;

/**
 * This class is the main class which runs the business and is used to get a list of employees and shows the result in
 * a hierarchical format.
 * Composite pattern is used in this solution.
 *
 * @author Bahar Javidan
 * @since 2019-11-17
 */
public class CodeChallengeApp {

    public static void main(String[] args) {
        DataRetriever dataRetriever = new DataRetriever();
        List<Employee> employees = dataRetriever.getData();

        EmployeeService employeeService = new EmployeeService();
        List<Employee> ceoList = employeeService.findCeo(employees);

        if (ceoList.size() == 0) {
            throw new RuntimeException("No High Manager Exist");
        }

        for (Employee ceo : ceoList) {
            employeeService.findSubordinate(employees, ceo);
            ceo.print(0);
        }
    }
}
