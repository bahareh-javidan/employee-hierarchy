package com.momenton.codechallenge.service;

import com.momenton.codechallenge.EmployeeFixture;
import com.momenton.codechallenge.domain.Employee;
import com.momenton.codechallenge.domain.Manager;
import com.momenton.codechallenge.domain.Subordinate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bahar Javidan
 * @since 2019-11-17
 */
public class EmployeeServiceTest {
    private EmployeeService employeeService;

    @Before
    public void setup() {
        employeeService = new EmployeeService();
    }

    @Test
    public void testCeoIsExist() {
        List<Employee> employees = EmployeeFixture.createEmployeesWithCeoFixture();
        Assert.assertEquals(1, employeeService.findCeo(employees).size());
    }

    @Test
    public void testCeoIsNotExist() {
        List<Employee> employees = EmployeeFixture.createEmployeesFixture();
        Assert.assertEquals(0, employeeService.findCeo(employees).size());
    }

    @Test
    public void testMultipleCeoIsExist() {
        List<Employee> employees = EmployeeFixture.createEmployeesWithMultipleCeoFixture();
        Assert.assertTrue(employeeService.findCeo(employees).size() > 0);
    }

    @Test
    public void testFindMidLevelSubordinate() {
        List<Employee> employees = EmployeeFixture.createEmployeesWithCeoFixture();
        Manager ceo = EmployeeFixture.createCeoFixture();
        employeeService.findSubordinate(employees, ceo);
        Assert.assertEquals(2, ceo.getEmployees().size());
    }

    @Test
    public void testSubordinateIsNotValid() {
        Employee invalidPerson = new Subordinate(300, "Jando", 111);
        List<Employee> employees = EmployeeFixture.createEmployeesWithCeoFixture();
        employees.add(invalidPerson);
        Manager ceo = EmployeeFixture.createCeoFixture();
        employeeService.findSubordinate(employees, ceo);
        Assert.assertEquals(2, ceo.getEmployees().size());
    }

    @Test
    public void testFindEmptySubordinate() {
        List<Employee> employees = new ArrayList<>();
        Manager ceo = EmployeeFixture.createCeoFixture();
        employeeService.findSubordinate(employees, ceo);
        Assert.assertEquals(0, ceo.getEmployees().size());
    }

    @Test
    public void testFindLeafSubordinate() {
        List<Employee> employees = EmployeeFixture.createEmployeesWithCeoFixture();
        Manager david = new Manager(190);

        employeeService.findSubordinate(employees, david);
        Assert.assertEquals(0, david.getEmployees().size());
    }
}
